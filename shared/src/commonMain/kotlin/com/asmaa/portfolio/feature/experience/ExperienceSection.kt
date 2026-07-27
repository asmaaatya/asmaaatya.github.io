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
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "EXPERIENCE",
                color = AppColors.Primary,
                style = AppTypography.labelLarge
            )
            
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "My professional journey so far",
                    color = AppColors.TextSecondary,
                    style = AppTypography.bodySmall
                )
                Box(
                    modifier = Modifier
                        .size(6.dp)
                        .background(AppColors.Primary, CircleShape)
                )
            }
        }

        Spacer(modifier = Modifier.height(64.dp))

        Column {
            experienceList.forEachIndexed { index, experience ->
                ExperienceTimelineItem(
                    experience = experience,
                    isLast = index == experienceList.size - 1
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
        // Timeline Column
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.width(48.dp)
        ) {
            // Dot
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .background(AppColors.Primary, CircleShape)
                    .border(4.dp, AppColors.Primary.copy(alpha = 0.2f), CircleShape)
            )
            
            // Line
            if (!isLast) {
                Box(
                    modifier = Modifier
                        .width(1.dp)
                        .weight(1f)
                        .background(AppColors.Border)
                )
            }
        }
        
        // Content Column
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = 48.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "${experience.startDate} - ${experience.endDate}",
                        style = AppTypography.bodyMedium,
                        color = AppColors.Primary
                    )
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Text(
                        text = experience.position,
                        style = AppTypography.titleLarge,
                        color = AppColors.TextPrimary
                    )
                    
                    Text(
                        text = experience.company,
                        style = AppTypography.bodyLarge.copy(fontWeight = FontWeight.Medium),
                        color = AppColors.TextSecondary
                    )
                }
                
                // Tags Row
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Displaying first 4 skills as tags
                    experience.description.take(4).forEach { skill ->
                         Box(
                            modifier = Modifier
                                .border(1.dp, AppColors.Border, RoundedCornerShape(4.dp))
                                .padding(horizontal = 12.dp, vertical = 6.dp)
                        ) {
                            Text(
                                text = skill.split(" ").first(), // Mocking tags
                                style = AppTypography.bodySmall,
                                color = AppColors.TextSecondary
                            )
                        }
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            experience.description.forEach { bullet ->
                Text(
                    text = bullet,
                    style = AppTypography.bodyMedium,
                    color = AppColors.TextSecondary,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }
    }
}

