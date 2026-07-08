package com.mista.weather.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.mista.weather.R

private val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs,
)

val AppFontFamily = FontFamily(
    Font(googleFont = GoogleFont("Inter"), fontProvider = provider, weight = FontWeight.Normal),
    Font(googleFont = GoogleFont("Inter"), fontProvider = provider, weight = FontWeight.Medium),
    Font(googleFont = GoogleFont("Inter"), fontProvider = provider, weight = FontWeight.SemiBold),
    Font(googleFont = GoogleFont("Inter"), fontProvider = provider, weight = FontWeight.Bold),
)

object AppFonts {
    val regular  = TextStyle(fontFamily = AppFontFamily, fontWeight = FontWeight.Normal,   fontSize = 14.sp, lineHeight = 20.sp)
    val medium   = TextStyle(fontFamily = AppFontFamily, fontWeight = FontWeight.Medium,   fontSize = 14.sp, lineHeight = 20.sp)
    val semiBold = TextStyle(fontFamily = AppFontFamily, fontWeight = FontWeight.SemiBold, fontSize = 14.sp, lineHeight = 20.sp)
    val bold     = TextStyle(fontFamily = AppFontFamily, fontWeight = FontWeight.Bold,     fontSize = 14.sp, lineHeight = 20.sp)
}

val AppTypography = Typography(
    displayLarge   = AppFonts.bold.copy(fontSize = 57.sp, lineHeight = 64.sp, letterSpacing = (-0.25).sp),
    displayMedium  = AppFonts.bold.copy(fontSize = 45.sp, lineHeight = 52.sp),
    displaySmall   = AppFonts.bold.copy(fontSize = 36.sp, lineHeight = 44.sp),
    headlineLarge  = AppFonts.bold.copy(fontSize = 32.sp, lineHeight = 40.sp),
    headlineMedium = AppFonts.semiBold.copy(fontSize = 28.sp, lineHeight = 36.sp),
    headlineSmall  = AppFonts.semiBold.copy(fontSize = 24.sp, lineHeight = 32.sp),
    titleLarge     = AppFonts.bold.copy(fontSize = 22.sp, lineHeight = 28.sp),
    titleMedium    = AppFonts.semiBold.copy(fontSize = 16.sp, lineHeight = 24.sp),
    titleSmall     = AppFonts.medium.copy(fontSize = 14.sp, lineHeight = 20.sp),
    bodyLarge      = AppFonts.regular.copy(fontSize = 16.sp, lineHeight = 24.sp),
    bodyMedium     = AppFonts.regular.copy(fontSize = 14.sp, lineHeight = 20.sp),
    bodySmall      = AppFonts.regular.copy(fontSize = 12.sp, lineHeight = 16.sp),
    labelLarge     = AppFonts.medium.copy(fontSize = 14.sp, lineHeight = 20.sp),
    labelMedium    = AppFonts.medium.copy(fontSize = 12.sp, lineHeight = 16.sp),
    labelSmall     = AppFonts.medium.copy(fontSize = 11.sp, lineHeight = 16.sp),
)
