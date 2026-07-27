package com.asmaa.portfolio.core.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val AppTypography = Typography(

    displayLarge = TextStyle(
        fontSize = 72.sp,
        lineHeight = 84.sp,
        fontWeight = FontWeight.Bold,
        color = AppColors.TextPrimary
    ),

    displayMedium = TextStyle(
        fontSize = 56.sp,
        lineHeight = 64.sp,
        fontWeight = FontWeight.Bold,
        color = AppColors.TextPrimary
    ),

    headlineLarge = TextStyle(
        fontSize = 40.sp,
        lineHeight = 48.sp,
        fontWeight = FontWeight.Bold,
        color = AppColors.TextPrimary
    ),

    headlineMedium = TextStyle(
        fontSize = 32.sp,
        lineHeight = 40.sp,
        fontWeight = FontWeight.SemiBold,
        color = AppColors.TextPrimary
    ),

    titleLarge = TextStyle(
        fontSize = 20.sp,
        lineHeight = 28.sp,
        fontWeight = FontWeight.SemiBold,
        color = AppColors.TextPrimary
    ),

    bodyLarge = TextStyle(
        fontSize = 16.sp,
        lineHeight = 26.sp,
        color = AppColors.TextSecondary
    ),

    bodyMedium = TextStyle(
        fontSize = 14.sp,
        lineHeight = 22.sp,
        color = AppColors.TextSecondary
    ),

    bodySmall = TextStyle(
        fontSize = 12.sp,
        lineHeight = 18.sp,
        color = AppColors.TextSecondary
    ),

    labelLarge = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = 2.sp
    )
)
