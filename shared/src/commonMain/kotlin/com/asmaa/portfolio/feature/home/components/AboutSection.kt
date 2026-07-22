package com.asmaa.portfolio.feature.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.asmaa.portfolio.core.theme.AppColors
import com.asmaa.portfolio.core.theme.AppTypography
import com.asmaa.portfolio.model.PersonalInfo

@Composable
fun AboutSection(
    personalInfo: PersonalInfo
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
            text = "ABOUT ME",
            color = AppColors.Primary,
            style = AppTypography.labelLarge
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = "Building meaningful\nmobile experiences.",
                    style = AppTypography.headlineMedium
                )
            }

            Spacer(
                modifier = Modifier.width(48.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = personalInfo.description,
                    style = AppTypography.bodyLarge
                )
            }
        }

        Spacer(
            modifier = Modifier.height(64.dp)
        )

        AboutStats(personalInfo.location)
    }
}

@Composable
private fun AboutStats(location: String) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        StatCard(
            value = "3+",
            label = "Years Experience",
            modifier = Modifier.weight(1f)
        )

        StatCard(
            value = location,
            label = "Current Location",
            modifier = Modifier.weight(1f)
        )

        StatCard(
            value = "Available",
            label = "Work Status",
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun StatCard(
    value: String,
    label: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(
                color = AppColors.Card,
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                width = 1.dp,
                color = AppColors.Border,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(24.dp)
    ) {

        Text(
            text = value,
            color = AppColors.Primary,
            style = AppTypography.titleLarge
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = label,
            style = AppTypography.bodyMedium
        )
    }
}
