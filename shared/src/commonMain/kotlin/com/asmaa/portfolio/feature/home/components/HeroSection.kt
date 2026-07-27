package com.asmaa.portfolio.feature.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Public
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.asmaa.portfolio.core.components.PrimaryButton
import com.asmaa.portfolio.core.components.SecondaryButton
import com.asmaa.portfolio.core.theme.AppColors
import com.asmaa.portfolio.core.theme.AppTypography
import com.asmaa.portfolio.model.PersonalInfo

@Composable
fun HeroSection(
    personalInfo: PersonalInfo
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 80.dp)
    ) {
        // Background Glow
        Box(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .size(600.dp)
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            AppColors.Primary.copy(alpha = 0.15f),
                            Color.Transparent
                        )
                    )
                )
                .blur(100.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 80.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1.2f)
            ) {
                Text(
                    text = "HELLO, I'M",
                    color = AppColors.Primary,
                    style = AppTypography.labelLarge
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = personalInfo.name,
                    style = AppTypography.displayLarge
                )

                Text(
                    text = personalInfo.title,
                    style = AppTypography.headlineMedium.copy(
                        color = AppColors.TextSecondary,
                        fontWeight = FontWeight.Normal
                    )
                )

                Spacer(modifier = Modifier.height(32.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    TechTag("Android")
                    TechTag("Flutter")
                    TechTag("Kotlin")
                    TechTag("Jetpack Compose")
                }

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = personalInfo.headline,
                    style = AppTypography.bodyLarge,
                    modifier = Modifier.fillMaxWidth(0.8f)
                )

                Spacer(modifier = Modifier.height(48.dp))

                HeroButtons()

                Spacer(modifier = Modifier.height(48.dp))

                SocialLinksRow()
            }

            // Phone Placeholder
            Box(
                modifier = Modifier
                    .weight(0.8f)
                    .aspectRatio(0.8f)
                    .padding(40.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            color = AppColors.Surface,
                            shape = RoundedCornerShape(32.dp)
                        )
                        .border(
                            width = 1.dp,
                            color = AppColors.Border,
                            shape = RoundedCornerShape(32.dp)
                        )
                ) {
                    // Inner screen placeholder
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(12.dp)
                            .background(
                                color = AppColors.Background,
                                shape = RoundedCornerShape(24.dp)
                            )
                    )
                }
            }
        }
    }
}

@Composable
private fun TechTag(name: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(6.dp)
                .background(AppColors.Primary, CircleShape)
        )
        Text(
            text = name,
            style = AppTypography.bodyMedium,
            color = AppColors.TextPrimary
        )
    }
}

@Composable
private fun HeroButtons() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        PrimaryButton(
            text = "View My Work",
            onClick = {}
        )

        SecondaryButton(
            text = "Download CV",
            onClick = {}
        )
    }
}

@Composable
private fun SocialLinksRow() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SocialLinkItem("GitHub", Icons.Default.Code)
        SocialLinkItem("LinkedIn", Icons.Default.Public)
        SocialLinkItem("Email", Icons.Default.Email)
    }
}

@Composable
private fun SocialLinkItem(label: String, icon: androidx.compose.ui.graphics.vector.ImageVector) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.clickable {}
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = AppColors.TextSecondary,
            modifier = Modifier.size(20.dp)
        )
        Text(
            text = label,
            style = AppTypography.bodyMedium,
            color = AppColors.TextSecondary
        )
    }
}

