package com.asmaa.portfolio.feature.experience

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
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
                vertical = 100.dp
            )
    ) {

        // =================================
        // SECTION HEADER
        // =================================

        Text(
            text = "EXPERIENCE",
            style = AppTypography.labelLarge,
            color = AppColors.Primary
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text(
            text = "My professional journey so far.",
            style = AppTypography.displayMedium,
            color = AppColors.TextPrimary,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(56.dp)
        )

        // =================================
        // TIMELINE
        // =================================

        Column {
            experienceList.forEachIndexed { index, experience ->

                ExperienceTimelineItem(
                    experience = experience,
                    isLast = index == experienceList.lastIndex
                )
            }
        }
    }
}

@Composable
private fun ExperienceTimelineItem(
    experience: Experience,
    isLast: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ) {

        // =================================
        // TIMELINE
        // =================================

        Column(
            modifier = Modifier
                .width(40.dp)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Timeline Dot
            Box(
                modifier = Modifier
                    .size(14.dp)
                    .background(
                        color = AppColors.Primary,
                        shape = CircleShape
                    )
                    .border(
                        width = 4.dp,
                        color = AppColors.Primary.copy(
                            alpha = 0.15f
                        ),
                        shape = CircleShape
                    )
            )

            // Timeline Line
            if (!isLast) {
                Box(
                    modifier = Modifier
                        .width(1.dp)
                        .weight(1f)
                        .background(
                            color = AppColors.Border
                        )
                )
            }
        }

        Spacer(
            modifier = Modifier.width(28.dp)
        )

        // =================================
        // EXPERIENCE CONTENT
        // =================================

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(
                    bottom = if (isLast) {
                        0.dp
                    } else {
                        64.dp
                    }
                )
        ) {

            // Date
            Text(
                text = buildString {
                    append(experience.startDate)
                    append(" — ")
                    append(experience.endDate)
                },
                style = AppTypography.bodyMedium,
                color = AppColors.Primary
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            // Position
            Text(
                text = experience.position,
                style = AppTypography.titleLarge,
                color = AppColors.TextPrimary,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            // Company
            Text(
                text = experience.company,
                style = AppTypography.bodyLarge.copy(
                    fontWeight = FontWeight.Medium
                ),
                color = AppColors.TextSecondary
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            // Description
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                experience.description.forEach { bullet ->

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.Top
                    ) {

                        Text(
                            text = "•",
                            color = AppColors.Primary,
                            style = AppTypography.bodyMedium
                        )

                        Spacer(
                            modifier = Modifier.width(10.dp)
                        )

                        Text(
                            text = bullet,
                            style = AppTypography.bodyMedium,
                            color = AppColors.TextSecondary
                        )
                    }
                }
            }
        }
    }
}