package com.asmaa.portfolio.core.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(

    primary = AppColors.Primary,

    background = AppColors.Background,

    surface = AppColors.Surface,

    onPrimary = AppColors.Background,

    onBackground = AppColors.TextPrimary,

    onSurface = AppColors.TextPrimary
)

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = AppTypography,
        content = content
    )
}