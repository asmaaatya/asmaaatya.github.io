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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.asmaa.portfolio.core.theme.AppColors
import com.asmaa.portfolio.core.theme.AppTypography
import com.asmaa.portfolio.model.Project

@Composable
fun ProjectsSection(
    projects: List<Project>
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
            text = "PROJECTS",
            color = AppColors.Primary,
            style = AppTypography.labelLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Featured Work",
            style = AppTypography.headlineMedium
        )

        Spacer(modifier = Modifier.height(48.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            projects.forEach { project ->
                ProjectCard(
                    title = project.title,
                    description = project.description,
                    tech = project.technologies
                )
            }
        }
    }
}

@Composable
private fun ProjectCard(
    title: String,
    description: String,
    tech: List<String>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(AppColors.Card, RoundedCornerShape(16.dp))
            .border(1.dp, AppColors.Border, RoundedCornerShape(16.dp))
            .padding(32.dp)
    ) {
        Text(
            text = title,
            style = AppTypography.titleLarge,
            color = AppColors.TextPrimary
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = description,
            style = AppTypography.bodyMedium,
            color = AppColors.TextSecondary
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            tech.forEach { tag ->
                Text(
                    text = tag,
                    style = AppTypography.labelLarge,
                    color = AppColors.Primary,
                    modifier = Modifier
                        .background(AppColors.Primary.copy(alpha = 0.1f), RoundedCornerShape(4.dp))
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                )
            }
        }
    }
}
