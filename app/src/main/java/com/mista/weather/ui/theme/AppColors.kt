package com.mista.weather.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class BaseAppColors(
    val primary: Color,
    val secondary: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val textDisabled: Color,
    val danger: Color,
    val highlight: Color,
    val base: Color,
    val baseInverse: Color,
    val divider: Color,
    val listDivider: Color,
    val border: Color,
    val background: Color,
    val backgroundSecondary: Color,
    val backgroundTertiary: Color,
    val sheetBackground: Color,
    val colorMuted: Color,
    val baseShade4: Color,
    val baseShadeWhite80: Color,
    val baseShadeWhite50: Color,
    val baseShadeWhite30: Color,
    val simulatorPrimary: Color,
    val warning: Color,
    val black: Color,
    val white: Color,
)

val LightAppColors = BaseAppColors(
    primary             = Color(0xFF2563EB),
    secondary           = Color(0xFF7C3AED),
    textPrimary         = Color(0xFF111827),
    textSecondary       = Color(0xFF6B7280),
    textDisabled        = Color(0xFFD1D5DB),
    danger              = Color(0xFFEF4444),
    highlight           = Color(0xFFF59E0B),
    base                = Color(0xFFFFFFFF),
    baseInverse         = Color(0xFF111827),
    divider             = Color(0xFFE5E7EB),
    listDivider         = Color(0xFFF3F4F6),
    border              = Color(0xFFD1D5DB),
    background          = Color(0xFFF9FAFB),
    backgroundSecondary = Color(0xFFF3F4F6),
    backgroundTertiary  = Color(0xFFE5E7EB),
    sheetBackground     = Color(0xFFFFFFFF),
    colorMuted          = Color(0xFF9CA3AF),
    baseShade4          = Color(0xFF374151),
    baseShadeWhite80    = Color(0xCCFFFFFF),
    baseShadeWhite50    = Color(0x80FFFFFF),
    baseShadeWhite30    = Color(0x4DFFFFFF),
    simulatorPrimary    = Color(0xFF0EA5E9),
    warning             = Color(0xFFF97316),
    black               = Color(0xFF000000),
    white               = Color(0xFFFFFFFF),
)

val DarkAppColors = BaseAppColors(
    primary             = Color(0xFF3B82F6),
    secondary           = Color(0xFF8B5CF6),
    textPrimary         = Color(0xFFF9FAFB),
    textSecondary       = Color(0xFF9CA3AF),
    textDisabled        = Color(0xFF4B5563),
    danger              = Color(0xFFF87171),
    highlight           = Color(0xFFFCD34D),
    base                = Color(0xFF1F2937),
    baseInverse         = Color(0xFFF9FAFB),
    divider             = Color(0xFF374151),
    listDivider         = Color(0xFF1F2937),
    border              = Color(0xFF4B5563),
    background          = Color(0xFF111827),
    backgroundSecondary = Color(0xFF1F2937),
    backgroundTertiary  = Color(0xFF374151),
    sheetBackground     = Color(0xFF1F2937),
    colorMuted          = Color(0xFF6B7280),
    baseShade4          = Color(0xFFD1D5DB),
    baseShadeWhite80    = Color(0xCCFFFFFF),
    baseShadeWhite50    = Color(0x80FFFFFF),
    baseShadeWhite30    = Color(0x4DFFFFFF),
    simulatorPrimary    = Color(0xFF38BDF8),
    warning             = Color(0xFFFB923C),
    black               = Color(0xFF000000),
    white               = Color(0xFFFFFFFF),
)

val LocalAppColors = staticCompositionLocalOf { LightAppColors }

object AppColors {
    val colors: BaseAppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalAppColors.current
}
