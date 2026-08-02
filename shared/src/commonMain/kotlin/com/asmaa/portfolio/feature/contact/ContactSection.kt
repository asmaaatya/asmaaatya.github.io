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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Link
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.asmaa.portfolio.core.theme.AppColors
import com.asmaa.portfolio.core.theme.AppTypography
import com.asmaa.portfolio.feature.home.components.PortfolioLogo
import com.asmaa.portfolio.model.PersonalInfo
import com.asmaa.portfolio.model.SocialLinks

@Composable
fun ContactSection(
    personalInfo: PersonalInfo,
    socialLinks: SocialLinks ,
    onBackToTopClick: () -> Unit = {},
    onEmailClick: () -> Unit = {},
    onLinkedInClick: () -> Unit = {},
    onGitHubClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        // =========================================================
        // CTA
        // =========================================================

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 80.dp,
                    vertical = 120.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Email Icon

            Box(
                modifier = Modifier
                    .size(72.dp)
                    .background(
                        color = AppColors.Primary.copy(alpha = 0.10f),
                        shape = CircleShape
                    )
                    .border(
                        width = 1.dp,
                        color = AppColors.Primary.copy(alpha = 0.25f),
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email",
                    tint = AppColors.Primary,
                    modifier = Modifier.size(28.dp)
                )
            }

            Spacer(
                modifier = Modifier.height(40.dp)
            )

            // Heading

            Text(
                text = buildAnnotatedString {

                    append("Let's build\n")

                    withStyle(
                        SpanStyle(
                            color = AppColors.Primary
                        )
                    ) {
                        append("something great")
                    }

                    append(" together.")
                },
                style = AppTypography.displayMedium,
                color = AppColors.TextPrimary,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            // Description

            Text(
                text = "Have a project in mind or looking for a mobile developer?\nI'd love to hear from you.",
                style = AppTypography.bodyLarge,
                color = AppColors.TextSecondary,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(40.dp)
            )

            // CTA Button

            ContactButton(
                text = "Get In Touch",
                onClick = onEmailClick
            )

            Spacer(
                modifier = Modifier.height(64.dp)
            )

            // Social Links

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                ContactSocialButton(
                    label = "Email",
                    icon = Icons.Default.Email,
                    onClick = onEmailClick
                )

                ContactSocialButton(
                    label = "LinkedIn",
                    icon = Icons.Default.Link,
                    onClick = onLinkedInClick
                )

                ContactSocialButton(
                    label = "GitHub",
                    icon = Icons.Default.Code,
                    onClick = onGitHubClick
                )
            }
        }

        HorizontalDivider(
            color = AppColors.Divider,
            thickness = 1.dp
        )

        // =========================================================
        // FOOTER
        // =========================================================

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 80.dp,
                    vertical = 32.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Logo

            PortfolioLogo()

            // Copyright

            Text(
                text = "© 2026 ${personalInfo.name}. All rights reserved.",
                style = AppTypography.bodySmall,
                color = AppColors.TextSecondary
            )

            // Back to top

            Row(
                modifier = Modifier
                    .clickable(
                        onClick = onBackToTopClick
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Text(
                    text = "Back to top",
                    style = AppTypography.bodySmall.copy(
                        fontWeight = FontWeight.SemiBold
                    ),
                    color = AppColors.TextSecondary
                )

                Icon(
                    imageVector = Icons.Default.ArrowUpward,
                    contentDescription = "Back to top",
                    tint = AppColors.Primary,
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}


@Composable
private fun ContactSocialButton(
    label: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .background(
                color = AppColors.Surface,
                shape = RoundedCornerShape(10.dp)
            )
            .border(
                width = 1.dp,
                color = AppColors.Border,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable(
                onClick = onClick
            )
            .padding(
                horizontal = 18.dp,
                vertical = 12.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = AppColors.Primary,
            modifier = Modifier.size(18.dp)
        )

        Text(
            text = label,
            style = AppTypography.bodySmall.copy(
                fontWeight = FontWeight.SemiBold
            ),
            color = AppColors.TextPrimary
        )
    }
}


@Composable
private fun ContactButton(
    text: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .background(
                color = AppColors.Primary,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable(
                onClick = onClick
            )
            .padding(
                horizontal = 28.dp,
                vertical = 15.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        Text(
            text = text,
            style = AppTypography.bodyLarge.copy(
                fontWeight = FontWeight.Bold
            ),
            color = AppColors.Background
        )

        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
            contentDescription = null,
            tint = AppColors.Background,
            modifier = Modifier.size(18.dp)
        )
    }
}