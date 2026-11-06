package com.example.smartvolt.ui.theme

import androidx.compose.material3.Typography as MaterialTypography
import com.example.smartvolt.R
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val GoogleSans = FontFamily(
    Font(R.font.google_sans_regular, FontWeight.Normal),
    Font(R.font.google_sans_medium, FontWeight.Medium),
    Font(R.font.google_sans_bold, FontWeight.Bold)
)

private val DefaultTypography = MaterialTypography()

val Typography = MaterialTypography(
    displayLarge = DefaultTypography.displayLarge.copy(fontFamily = GoogleSans),
    displayMedium = DefaultTypography.displayMedium.copy(fontFamily = GoogleSans),
    displaySmall = DefaultTypography.displaySmall.copy(fontFamily = GoogleSans),
    headlineLarge = DefaultTypography.headlineLarge.copy(fontFamily = GoogleSans),
    headlineMedium = DefaultTypography.headlineMedium.copy(fontFamily = GoogleSans),
    headlineSmall = DefaultTypography.headlineSmall.copy(fontFamily = GoogleSans),
    titleLarge = DefaultTypography.titleLarge.copy(fontFamily = GoogleSans),
    titleMedium = DefaultTypography.titleMedium.copy(fontFamily = GoogleSans),
    titleSmall = DefaultTypography.titleSmall.copy(fontFamily = GoogleSans),
    bodyLarge = TextStyle(
        fontFamily = GoogleSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = DefaultTypography.bodyMedium.copy(fontFamily = GoogleSans),
    bodySmall = DefaultTypography.bodySmall.copy(fontFamily = GoogleSans),
    labelLarge = DefaultTypography.labelLarge.copy(fontFamily = GoogleSans),
    labelMedium = DefaultTypography.labelMedium.copy(fontFamily = GoogleSans),
    labelSmall = DefaultTypography.labelSmall.copy(fontFamily = GoogleSans)
)