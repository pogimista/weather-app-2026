package com.mista.weather.session

import android.content.SharedPreferences
import androidx.core.content.edit
import com.squareup.moshi.Moshi
import java.lang.reflect.Type

class PersistentCacheWrapper<T>(
    private val sharedPreferences: SharedPreferences,
    private val key: String,
    private val type: Type,
    private val moshi: Moshi,
) : CacheWrapper<T> {

    private val adapter by lazy { moshi.adapter<T>(type) }

    override var value: T?
        get() = sharedPreferences.getString(key, null)?.let { adapter.fromJson(it) }
        set(value) {
            if (value == null) {
                sharedPreferences.edit { remove(key) }
            } else {
                sharedPreferences.edit { putString(key, adapter.toJson(value)) }
            }
        }

    override fun clear() {
        sharedPreferences.edit { remove(key) }
    }
}
