package com.asmaa.portfolio.core.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val AppTypography = Typography(

    displayLarge = TextStyle(
        fontSize = 64.sp,
        lineHeight = 72.sp,
        fontWeight = FontWeight.Bold,
        color = AppColors.TextPrimary
    ),

    headlineLarge = TextStyle(
        fontSize = 48.sp,
        lineHeight = 56.sp,
        fontWeight = FontWeight.Bold,
        color = AppColors.TextPrimary
    ),

    headlineMedium = TextStyle(
        fontSize = 36.sp,
        lineHeight = 44.sp,
        fontWeight = FontWeight.Bold,
        color = AppColors.TextPrimary
    ),

    titleLarge = TextStyle(
        fontSize = 24.sp,
        lineHeight = 32.sp,
        fontWeight = FontWeight.SemiBold,
        color = AppColors.TextPrimary
    ),

    bodyLarge = TextStyle(
        fontSize = 18.sp,
        lineHeight = 28.sp,
        color = AppColors.TextSecondary
    ),

    bodyMedium = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        color = AppColors.TextSecondary
    ),

    labelLarge = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium
    )
)
