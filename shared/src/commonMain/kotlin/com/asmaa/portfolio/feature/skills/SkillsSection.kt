package com.asmaa.portfolio.feature.skills

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
                vertical = 60.dp
            )
    ) {

        Text(
            text = "TECH STACK",
            color = AppColors.Primary,
            style = AppTypography.labelLarge
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Text(
            text = "Technologies I work with",
            style = AppTypography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(48.dp)
        )

        SkillGrid(skills)
    }
}

@Composable
private fun SkillGrid(skillCategories: List<Skill>) {
    // We can display these in a grid-like fashion using Rows of 2 items each
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        skillCategories.chunked(2).forEach { rowSkills ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                rowSkills.forEach { skillCategory ->
                    SkillCategoryCard(
                        title = skillCategory.category,
                        skills = skillCategory.items,
                        modifier = Modifier.weight(1f)
                    )
                }
                // Add an empty spacer if the row has only one item to keep alignment
                if (rowSkills.size == 1) {
                    Spacer(modifier = Modifier.weight(1f))
                }
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

    Column(
        modifier = modifier
            .background(
                AppColors.Card,
                RoundedCornerShape(16.dp)
            )
            .border(
                1.dp,
                AppColors.Border,
                RoundedCornerShape(16.dp)
            )
            .padding(28.dp)
    ) {

        Text(
            text = title,
            color = AppColors.Primary,
            style = AppTypography.titleLarge
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        skills.forEach { skill ->

            Text(
                text = "•  $skill",
                color = AppColors.TextSecondary,
                style = AppTypography.bodyMedium,
                modifier = Modifier.padding(
                    vertical = 4.dp
                )
            )
        }
    }
}
