package com.asmaa.portfolio.feature.skills

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.Architecture
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Layers
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asmaa.portfolio.core.theme.AppColors
import com.asmaa.portfolio.core.theme.AppTypography
import com.asmaa.portfolio.model.Skill

@Composable
fun SkillsSection(
    skills: List<Skill>
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
                text = "MY TECH STACK",
                color = AppColors.Primary,
                style = AppTypography.labelLarge
            )
            
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Always learning new technologies",
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

        SkillGrid(skills)
    }
}

@Composable
private fun SkillGrid(skillCategories: List<Skill>) {
    // 4 columns in the design
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        skillCategories.forEach { skillCategory ->
            SkillCategoryCard(
                title = skillCategory.category,
                skills = skillCategory.items,
                modifier = Modifier.weight(1f)
            )
        }
        
        // Fill up to 4 columns if less
        repeat(4 - skillCategories.size.coerceAtMost(4)) {
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
private fun SkillCategoryCard(
    title: String,
    skills: List<String>,
    modifier: Modifier = Modifier
) {
    val categoryIcon = when {
        title.contains("Android", ignoreCase = true) -> Icons.Default.Android
        title.contains("Cross", ignoreCase = true) -> Icons.Default.Layers
        title.contains("Architecture", ignoreCase = true) -> Icons.Default.Architecture
        else -> Icons.Default.Build
    }

    Column(
        modifier = modifier
            .background(AppColors.Surface, RoundedCornerShape(16.dp))
            .border(1.dp, AppColors.Border, RoundedCornerShape(16.dp))
            .padding(24.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Icon(
                imageVector = categoryIcon,
                contentDescription = null,
                tint = AppColors.Primary,
                modifier = Modifier.size(24.dp)
            )
            
            Text(
                text = title,
                style = AppTypography.titleLarge.copy(fontSize = 18.sp),
                color = AppColors.TextPrimary
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            skills.forEach { skill ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Done,
                        contentDescription = null,
                        tint = AppColors.Primary,
                        modifier = Modifier.size(16.dp)
                    )
                    
                    Text(
                        text = skill,
                        color = AppColors.TextSecondary,
                        style = AppTypography.bodyMedium
                    )
                }
            }
        }
    }
}
