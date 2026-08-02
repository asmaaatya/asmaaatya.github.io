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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Public
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.asmaa.portfolio.core.components.PrimaryButton
import com.asmaa.portfolio.core.components.SecondaryButton
import com.asmaa.portfolio.core.theme.AppColors
import com.asmaa.portfolio.core.theme.AppTypography
import com.asmaa.portfolio.model.PersonalInfo

@Composable
fun HeroSection(
    personalInfo: PersonalInfo,
    onViewMyWorkClick: () -> Unit
){

    val horizontalPadding =  80.dp

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(AppColors.Background)
    ) {

        // Background Glow
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .size(550.dp)
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            AppColors.Primary.copy(alpha = 0.12f),
                            Color.Transparent
                        )
                    )
                )
                .blur( 120.dp)
        )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = horizontalPadding, vertical = 80.dp),
                horizontalArrangement = Arrangement.spacedBy(80.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                HeroContent(
                    personalInfo = personalInfo,
                    isCompact = false,
                    onViewMyWorkClick = onViewMyWorkClick,
                    modifier = Modifier.weight(1.2f)
                )
                PhoneMockup(
                    modifier = Modifier.weight(0.8f)
                )
            }
        }
    }

@Composable
private fun HeroContent(
    personalInfo: PersonalInfo,
    isCompact: Boolean,
    onViewMyWorkClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = if (isCompact) Alignment.CenterHorizontally else Alignment.Start
    ) {
        Text(
            text = "HELLO, I'M",
            color = AppColors.Primary,
            style = AppTypography.labelLarge
        )

        Spacer(modifier = Modifier.height(if (isCompact) 12.dp else 20.dp))

        Text(
            text = personalInfo.name,
            style = if (isCompact) AppTypography.displayMedium else AppTypography.displayLarge,
            color = AppColors.TextPrimary,
            textAlign = if (isCompact) TextAlign.Center else null
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = personalInfo.title,
            style = (if (isCompact) AppTypography.headlineSmall else AppTypography.headlineMedium).copy(
                color = AppColors.TextSecondary,
                fontWeight = FontWeight.Normal
            ),
            textAlign = if (isCompact) TextAlign.Center else null
        )

        Spacer(modifier = Modifier.height(if (isCompact) 20.dp else 28.dp))

        // Technologies
        if (isCompact) {
            androidx.compose.foundation.layout.FlowRow(
                horizontalArrangement = Arrangement.Center,
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                TechTag("Android")
                Spacer(Modifier.width(12.dp))
                TechTag("Kotlin")
                Spacer(Modifier.width(12.dp))
                TechTag("Compose")
                Spacer(Modifier.width(12.dp))
                TechTag("Flutter")
            }
        } else {
            Row(
                horizontalArrangement = Arrangement.spacedBy(18.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TechTag("Android")
                TechTag("Kotlin")
                TechTag("Jetpack Compose")
                TechTag("Flutter")
            }
        }

        Spacer(modifier = Modifier.height(if (isCompact) 20.dp else 28.dp))

        Text(
            text = personalInfo.headline,
            style = AppTypography.bodyLarge,
            color = AppColors.TextSecondary,
            modifier = Modifier.fillMaxWidth(if (isCompact) 1f else 0.85f),
            textAlign = if (isCompact) TextAlign.Center else null
        )

        Spacer(modifier = Modifier.height(if (isCompact) 32.dp else 40.dp))

        HeroButtons(
            onViewMyWorkClick = onViewMyWorkClick,
            isCompact = isCompact
        )

        Spacer(modifier = Modifier.height(if (isCompact) 32.dp else 36.dp))

        SocialLinksRow(isCompact = isCompact)
    }
}

@Composable
private fun PhoneMockup(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(0.65f),
        contentAlignment = Alignment.Center
    ) {

        // Glow behind phone
        Box(
            modifier = Modifier
                .size(420.dp)
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            AppColors.Primary.copy(alpha = 0.12f),
                            Color.Transparent
                        )
                    )
                )
                .blur(80.dp)
        )

        // Phone Frame
        Box(
            modifier = Modifier
                .fillMaxSize(0.72f)
                .background(
                    color = Color(0xFF090A09),
                    shape = RoundedCornerShape(36.dp)
                )
                .border(
                    width = 1.dp,
                    color = AppColors.Border,
                    shape = RoundedCornerShape(36.dp)
                )
                .padding(10.dp)
        ) {

            // Phone Screen
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = AppColors.Surface,
                        shape = RoundedCornerShape(28.dp)
                    )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "APP",
                        style = AppTypography.titleLarge,
                        color = AppColors.Primary
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "Mobile Experience",
                        style = AppTypography.bodySmall,
                        color = AppColors.TextSecondary
                    )
                }
            }
        }
    }
}

@Composable
private fun TechTag(
    name: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Box(
            modifier = Modifier
                .size(5.dp)
                .background(
                    color = AppColors.Primary,
                    shape = CircleShape
                )
        )

        Text(
            text = name,
            style = AppTypography.bodySmall,
            color = AppColors.TextSecondary
        )
    }
}

@Composable
private fun HeroButtons(
    onViewMyWorkClick: () -> Unit,
    isCompact: Boolean
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = if (isCompact) Modifier.fillMaxWidth() else Modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        PrimaryButton(
            text = "View My Work",
            onClick = onViewMyWorkClick,
            modifier = if (isCompact) Modifier.weight(1f) else Modifier
        )

        SecondaryButton(
            text = "Download CV",
            onClick = {
                // هنربطه بالـ CV بعدين
            },
            modifier = if (isCompact) Modifier.weight(1f) else Modifier
        )
    }
}

@Composable
private fun SocialLinksRow(isCompact: Boolean) {
    Row(
        horizontalArrangement = if (isCompact) Arrangement.Center else Arrangement.spacedBy(24.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = if (isCompact) Modifier.fillMaxWidth() else Modifier
    ) {
        SocialLinkItem(label = "GitHub", icon = Icons.Default.Code)
        Spacer(Modifier.width(if (isCompact) 20.dp else 24.dp))
        SocialLinkItem(label = "LinkedIn", icon = Icons.Default.Public)
        Spacer(Modifier.width(if (isCompact) 20.dp else 24.dp))
        SocialLinkItem(label = "Email", icon = Icons.Default.Email)
    }
}

@Composable
private fun SocialLinkItem(
    label: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector
) {
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
