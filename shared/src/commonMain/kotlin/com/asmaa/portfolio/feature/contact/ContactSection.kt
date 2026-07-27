package com.asmaa.portfolio.feature.contact

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Public
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asmaa.portfolio.core.navigation.NavigationItem
import com.asmaa.portfolio.core.theme.AppColors
import com.asmaa.portfolio.core.theme.AppTypography
import com.asmaa.portfolio.feature.home.components.PortfolioLogo
import com.asmaa.portfolio.model.PersonalInfo
import com.asmaa.portfolio.model.SocialLinks

@Composable
fun ContactSection(
    personalInfo: PersonalInfo,
    socialLinks: SocialLinks
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        // CTA Section
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 80.dp, vertical = 120.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Icon
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .background(AppColors.Primary.copy(alpha = 0.1f), CircleShape)
                    .border(1.dp, AppColors.Primary.copy(alpha = 0.2f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null,
                    tint = AppColors.Primary,
                    modifier = Modifier.size(32.dp)
                )
            }

            Spacer(modifier = Modifier.height(48.dp))

            Text(
                text = buildAnnotatedString {
                    append("Let's Build\nSomething ")
                    withStyle(SpanStyle(color = AppColors.Primary)) {
                        append("Great")
                    }
                    append(" Together")
                },
                style = AppTypography.displayMedium,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "I'm currently open to new opportunities and\nexciting projects. Let's connect!",
                style = AppTypography.bodyLarge,
                color = AppColors.TextSecondary,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

            Spacer(modifier = Modifier.height(48.dp))

            Box(
                modifier = Modifier
                    .background(AppColors.Primary, RoundedCornerShape(8.dp))
                    .clickable {}
                    .padding(horizontal = 32.dp, vertical = 16.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Get In Touch",
                        style = AppTypography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                        color = AppColors.Background
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = null,
                        tint = AppColors.Background,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(80.dp))
            
            // Social Links Row
            Row(
                horizontalArrangement = Arrangement.spacedBy(48.dp)
            ) {
                ContactLinkItem("Email", personalInfo.email)
                ContactLinkItem("LinkedIn", "linkedin.com/in/asmaa-atya")
                ContactLinkItem("GitHub", "github.com/asmaa-atya")
            }
        }

        HorizontalDivider(color = AppColors.Divider, thickness = 1.dp)

        // Footer
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 80.dp, vertical = 48.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PortfolioLogo()
            
            Text(
                text = "© 2026 ${personalInfo.name}. All rights reserved.",
                style = AppTypography.bodySmall,
                color = AppColors.TextSecondary
            )

        }
    }
}

@Composable
private fun ContactLinkItem(label: String, value: String) {
    val icon = when (label) {
        "Email" -> Icons.Default.Email
        "GitHub" -> Icons.Default.Code
        "LinkedIn" -> Icons.Default.Public
        else -> Icons.Default.Public
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(AppColors.TextSecondary.copy(alpha = 0.1f), RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = AppColors.Primary,
                modifier = Modifier.size(20.dp)
            )
        }
        Column {
            Text(
                text = label,
                style = AppTypography.labelLarge,
                color = AppColors.TextSecondary
            )
            Text(
                text = value,
                style = AppTypography.bodyMedium,
                color = AppColors.TextPrimary
            )
        }
    }
}

