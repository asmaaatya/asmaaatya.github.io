package com.asmaa.portfolio.feature.projects

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowOutward
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
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
                vertical = 100.dp
            )
    ) {

        // ==============================
        // SECTION HEADER
        // ==============================

        Text(
            text = "FEATURED PROJECTS",
            style = AppTypography.labelLarge,
            color = AppColors.Primary
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text(
            text = "A selection of things I've built.",
            style = AppTypography.displayMedium,
            color = AppColors.TextPrimary,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(56.dp)
        )

        // ==============================
        // PROJECTS
        // ==============================

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {

            projects
                .take(3)
                .forEach { project ->

                    ProjectCard(
                        project = project,
                        modifier = Modifier.weight(1f)
                    )
                }
        }
    }
}

@Composable
private fun ProjectCard(
    project: Project,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(
                color = AppColors.Surface,
                shape = RoundedCornerShape(20.dp)
            )
            .border(
                width = 1.dp,
                color = AppColors.Border,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(20.dp)
    ) {

        // ==============================
        // PROJECT PREVIEW
        // ==============================

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.35f)
                .background(
                    color = AppColors.Background,
                    shape = RoundedCornerShape(14.dp)
                )
                .border(
                    width = 1.dp,
                    color = AppColors.Border,
                    shape = RoundedCornerShape(14.dp)
                ),
            contentAlignment = Alignment.Center
        ) {

            // Temporary placeholder
            // Replace with project mockup/image later

            Icon(
                imageVector = Icons.Default.Folder,
                contentDescription = null,
                tint = AppColors.Primary.copy(
                    alpha = 0.15f
                ),
                modifier = Modifier.size(72.dp)
            )

            // Project Type Icon
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(12.dp)
                    .size(36.dp)
                    .background(
                        color = AppColors.Primary.copy(
                            alpha = 0.10f
                        ),
                        shape = RoundedCornerShape(10.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = Icons.Default.Folder,
                    contentDescription = null,
                    tint = AppColors.Primary,
                    modifier = Modifier.size(18.dp)
                )
            }
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        // ==============================
        // PROJECT NAME
        // ==============================

        Text(
            text = project.name,
            style = AppTypography.titleLarge,
            color = AppColors.TextPrimary,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        // ==============================
        // DESCRIPTION
        // ==============================

        Text(
            text = project.description,
            style = AppTypography.bodyMedium,
            color = AppColors.TextSecondary,
            maxLines = 3
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        // ==============================
        // TECHNOLOGIES
        // ==============================

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            project.technologies
                .take(3)
                .forEach { technology ->

                    TechnologyTag(
                        text = technology
                    )
                }
        }

        Spacer(
            modifier = Modifier.height(28.dp)
        )

        // ==============================
        // VIEW PROJECT
        // ==============================

        Row(
            modifier = Modifier
                .clickable {
                    // TODO: Open project details
                },
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "View Project",
                style = AppTypography.bodySmall.copy(
                    fontWeight = FontWeight.SemiBold
                ),
                color = AppColors.Primary
            )

            Spacer(
                modifier = Modifier.width(6.dp)
            )

            Icon(
                imageVector = Icons.Default.ArrowOutward,
                contentDescription = "View Project",
                tint = AppColors.Primary,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
private fun TechnologyTag(
    text: String
) {
    Box(
        modifier = Modifier
            .background(
                color = AppColors.Background,
                shape = RoundedCornerShape(6.dp)
            )
            .border(
                width = 1.dp,
                color = AppColors.Border,
                shape = RoundedCornerShape(6.dp)
            )
            .padding(
                horizontal = 10.dp,
                vertical = 6.dp
            )
    ) {

        Text(
            text = text,
            style = AppTypography.bodySmall,
            color = AppColors.TextSecondary
        )
    }
}