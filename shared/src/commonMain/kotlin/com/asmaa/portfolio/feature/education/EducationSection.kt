package com.asmaa.portfolio.feature.education

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
import com.asmaa.portfolio.model.Education

@Composable
fun EducationSection(
    education: Education
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
            text = "EDUCATION",
            color = AppColors.Primary,
            style = AppTypography.labelLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "My Academic Background",
            style = AppTypography.headlineMedium
        )

        Spacer(modifier = Modifier.height(48.dp))

        EducationCard(education)
    }
}

@Composable
private fun EducationCard(education: Education) {
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
                    text = education.degree,
                    style = AppTypography.titleLarge,
                    color = AppColors.TextPrimary
                )
                Text(
                    text = education.university,
                    style = AppTypography.bodyLarge,
                    color = AppColors.Primary
                )
            }
            Text(
                text = "${education.startDate} - ${education.endDate}",
                style = AppTypography.bodyMedium,
                color = AppColors.TextSecondary
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = education.location,
            style = AppTypography.bodyMedium,
            color = AppColors.TextSecondary
        )
        Text(
            text = "Grade: ${education.grade}",
            style = AppTypography.bodyMedium,
            color = AppColors.TextSecondary
        )
    }
}
