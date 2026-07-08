package com.mista.weather.ui.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.mista.weather.ui.theme.AppColors
import com.mista.weather.ui.theme.AppFonts

data class LoadingDialogState(
    val isVisible: Boolean = false,
    val message: String = "",
    val cancellable: Boolean = true,
)

@Composable
fun LoadingDialog(
    state: LoadingDialogState,
    onDismiss: () -> Unit,
) {
    if (!state.isVisible) return

    val colors = AppColors.colors

    val pulse by rememberInfiniteTransition(label = "pulse").animateFloat(
        initialValue = 0.92f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(600, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse,
        ),
        label = "pulseScale",
    )

    Dialog(
        onDismissRequest = { if (state.cancellable) onDismiss() },
        properties = DialogProperties(
            dismissOnBackPress = state.cancellable,
            dismissOnClickOutside = state.cancellable,
            usePlatformDefaultWidth = false,
        ),
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(24.dp))
                .background(colors.sheetBackground)
                .padding(horizontal = 48.dp, vertical = 36.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(52.dp)
                    .scale(pulse),
                color = colors.primary,
                trackColor = colors.backgroundSecondary,
                strokeWidth = 3.dp,
            )

            if (state.message.isNotBlank()) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = state.message,
                    style = AppFonts.medium.copy(color = colors.textSecondary),
                )
            }
        }
    }
}
