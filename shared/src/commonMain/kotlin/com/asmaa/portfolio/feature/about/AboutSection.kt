package com.asmaa.portfolio.feature.about

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.asmaa.portfolio.core.theme.AppColors
import com.asmaa.portfolio.core.theme.AppTypography
import com.asmaa.portfolio.model.About
import com.asmaa.portfolio.model.PersonalInfo

@Composable
fun AboutSection(
    about: About,
    personalInfo: PersonalInfo
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 80.dp,
                vertical = 100.dp
            )
    ) {

        // Section Label
        Text(
            text = "ABOUT ME",
            style = AppTypography.labelLarge,
            color = AppColors.Primary
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        // Main Heading
        Text(
            text = "Building meaningful\nmobile experiences.",
            style = AppTypography.displayMedium,
            color = AppColors.TextPrimary,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(32.dp)
        )

        // Description
        Text(
            text = about.description,
            style = AppTypography.bodyLarge,
            color = AppColors.TextSecondary,
            modifier = Modifier.fillMaxWidth(0.7f)
        )

        Spacer(
            modifier = Modifier.height(56.dp)
        )

        // Statistics
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            AboutStatCard(
                value = "3+",
                label = "Years Experience",
                modifier = Modifier.weight(1f)
            )

            AboutStatCard(
                value = "15+",
                label = "Projects",
                modifier = Modifier.weight(1f)
            )

            AboutStatCard(
                value = "2",
                label = "Platforms",
                modifier = Modifier.weight(1f)
            )

            AboutStatCard(
                value = "100%",
                label = "Passion",
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun AboutStatCard(
    value: String,
    label: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(
                color = AppColors.Surface,
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                width = 1.dp,
                color = AppColors.Border,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(
                horizontal = 24.dp,
                vertical = 28.dp
            ),
        horizontalAlignment = Alignment.Start
    ) {

        // Green Accent
        Box(
            modifier = Modifier
                .size(6.dp)
                .background(
                    color = AppColors.Primary,
                    shape = RoundedCornerShape(50)
                )
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text(
            text = value,
            style = AppTypography.headlineLarge,
            color = AppColors.Primary,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = label,
            style = AppTypography.bodySmall,
            color = AppColors.TextSecondary
        )
    }
}