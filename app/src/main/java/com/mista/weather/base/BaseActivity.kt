package com.mista.weather.base

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zhuinden.simplestack.Backstack
import com.zhuinden.simplestack.History
import com.zhuinden.simplestack.StateChange
import com.zhuinden.simplestack.StateChanger

internal class BackstackViewModel : ViewModel() {
    val backstack = Backstack()
    var initialized = false
}

abstract class BaseActivity : AppCompatActivity(), StateChanger {

    abstract val initialKey: BaseKey
    @get:IdRes abstract val containerId: Int

    private val backstackViewModel: BackstackViewModel by lazy {
        ViewModelProvider(this)[BackstackViewModel::class.java]
    }

    val backstack: Backstack get() = backstackViewModel.backstack

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        if (!backstackViewModel.initialized) {
            backstackViewModel.initialized = true
            backstackViewModel.backstack.setup(History.of(initialKey))
        }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (!backstackViewModel.backstack.goBack()) {
                    isEnabled = false
                    onBackPressedDispatcher.onBackPressed()
                }
            }
        })
    }

    override fun onResume() {
        super.onResume()
        backstackViewModel.backstack.setStateChanger(this)
    }

    override fun onPause() {
        backstackViewModel.backstack.removeStateChanger()
        super.onPause()
    }

    override fun handleStateChange(stateChange: StateChange, completionCallback: StateChanger.Callback) {
        if (stateChange.isTopNewKeyEqualToPrevious) {
            completionCallback.stateChangeComplete()
            return
        }

        val newKey = stateChange.topNewKey<BaseKey>()
        val (enterAnim, exitAnim) = when (stateChange.direction) {
            StateChange.FORWARD -> {
                val anims = newKey.animation.anims()
                Pair(anims?.enter ?: 0, anims?.exit ?: 0)
            }
            StateChange.BACKWARD -> {
                val anims = stateChange.topPreviousKey<BaseKey>()?.animation?.anims()
                Pair(anims?.popEnter ?: 0, anims?.popExit ?: 0)
            }
            else -> Pair(0, 0)
        }

        supportFragmentManager.commit {
            if (enterAnim != 0 || exitAnim != 0) {
                setCustomAnimations(enterAnim, exitAnim, 0, 0)
            }
            replace(containerId, newKey.instantiateFragment(), newKey.fragmentTag)
        }
        completionCallback.stateChangeComplete()
    }
}
