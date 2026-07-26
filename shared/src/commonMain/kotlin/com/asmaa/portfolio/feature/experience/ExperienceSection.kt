package com.asmaa.portfolio.feature.experience

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.asmaa.portfolio.core.theme.AppColors
import com.asmaa.portfolio.core.theme.AppTypography
import com.asmaa.portfolio.model.Experience

@Composable
fun ExperienceSection(
    experienceList: List<Experience>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 80.dp,
                vertical = 60.dp
            )
    ) {
        Text(
            text = "EXPERIENCE",
            color = AppColors.Primary,
            style = AppTypography.labelLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Where I've worked",
            style = AppTypography.headlineMedium
        )

        Spacer(modifier = Modifier.height(48.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            experienceList.forEach { experience ->
                ExperienceCard(
                    company = experience.company,
                    position = experience.position,
                    period = "${experience.startDate} - ${experience.endDate}",
                    description = experience.description
                )
            }
        }
    }
}

@Composable
private fun ExperienceCard(
    company: String,
    position: String,
    period: String,
    description: List<String>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(AppColors.Card, RoundedCornerShape(16.dp))
            .border(1.dp, AppColors.Border, RoundedCornerShape(16.dp))
            .padding(32.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = position,
                    style = AppTypography.titleLarge,
                    color = AppColors.TextPrimary
                )
                Text(
                    text = company,
                    style = AppTypography.bodyLarge,
                    color = AppColors.Primary
                )
            }
            Text(
                text = period,
                style = AppTypography.bodyMedium,
                color = AppColors.TextSecondary
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        description.forEach { bullet ->
            Text(
                text = "•  $bullet",
                style = AppTypography.bodyMedium,
                color = AppColors.TextSecondary,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }
    }
}
