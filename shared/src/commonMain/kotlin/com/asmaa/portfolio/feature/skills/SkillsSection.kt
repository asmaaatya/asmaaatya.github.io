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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.Architecture
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Layers
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
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

        // ==============================
        // HEADER
        // ==============================

        Text(
            text = "MY TECH STACK",
            style = AppTypography.labelLarge,
            color = AppColors.Primary
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text(
            text = "Technologies I work with to build modern\nand scalable mobile applications.",
            style = AppTypography.displayMedium,
            color = AppColors.TextPrimary,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = "Always learning, exploring new tools, and improving my craft.",
            style = AppTypography.bodyLarge,
            color = AppColors.TextSecondary
        )

        Spacer(
            modifier = Modifier.height(56.dp)
        )

        // ==============================
        // SKILLS GRID
        // ==============================

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            skills
                .take(4)
                .forEach { skillCategory ->

                    SkillCategoryCard(
                        title = skillCategory.category,
                        skills = skillCategory.items,
                        modifier = Modifier.weight(1f)
                    )
                }
        }
    }
}

@Composable
private fun SkillCategoryCard(
    title: String,
    skills: List<String>,
    modifier: Modifier = Modifier
) {

    val categoryIcon = getCategoryIcon(title)

    Column(
        modifier = modifier
            .background(
                color = AppColors.Surface,
                shape = RoundedCornerShape(18.dp)
            )
            .border(
                width = 1.dp,
                color = AppColors.Border,
                shape = RoundedCornerShape(18.dp)
            )
            .padding(24.dp)
    ) {

        // ==============================
        // ICON
        // ==============================

        Box(
            modifier = Modifier
                .size(48.dp)
                .background(
                    color = AppColors.Primary.copy(alpha = 0.10f),
                    shape = RoundedCornerShape(12.dp)
                ),
            contentAlignment = Alignment.Center
        ) {

            Icon(
                imageVector = categoryIcon,
                contentDescription = title,
                tint = AppColors.Primary,
                modifier = Modifier.size(24.dp)
            )
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        // ==============================
        // CATEGORY TITLE
        // ==============================

        Text(
            text = title,
            style = AppTypography.titleLarge,
            color = AppColors.TextPrimary,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        // ==============================
        // SKILLS
        // ==============================

        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            skills.forEach { skill ->

                SkillItem(
                    skill = skill
                )
            }
        }
    }
}

@Composable
private fun SkillItem(
    skill: String
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(6.dp)
                .background(
                    color = AppColors.Primary,
                    shape = RoundedCornerShape(50)
                )
        )

        Spacer(
            modifier = Modifier.width(10.dp)
        )

        Text(
            text = skill,
            style = AppTypography.bodyMedium,
            color = AppColors.TextSecondary
        )
    }
}

private fun getCategoryIcon(
    category: String
): ImageVector {

    return when {

        category.contains(
            "Android",
            ignoreCase = true
        ) -> Icons.Default.Android

        category.contains(
            "Cross",
            ignoreCase = true
        ) -> Icons.Default.Layers

        category.contains(
            "Architecture",
            ignoreCase = true
        ) -> Icons.Default.Architecture

        else -> Icons.Default.Build
    }
}