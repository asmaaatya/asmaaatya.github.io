package com.asmaa.portfolio.feature.contact

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.asmaa.portfolio.core.components.PrimaryButton
import com.asmaa.portfolio.core.theme.AppColors
import com.asmaa.portfolio.core.theme.AppTypography
import com.asmaa.portfolio.model.PersonalInfo
import com.asmaa.portfolio.model.SocialLinks

@Composable
fun ContactSection(
    personalInfo: PersonalInfo,
    socialLinks: SocialLinks
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 80.dp,
                vertical = 120.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "CONTACT",
            color = AppColors.Primary,
            style = AppTypography.labelLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Let's work together",
            style = AppTypography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "I'm currently available for new opportunities.\nFeel free to reach out via email or LinkedIn.",
            style = AppTypography.bodyLarge,
            color = AppColors.TextSecondary,
            modifier = Modifier.padding(horizontal = 48.dp)
        )

        Spacer(modifier = Modifier.height(48.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            PrimaryButton(
                text = "Email Me",
                onClick = { /* Handle email via socialLinks.email */ }
            )
            
            PrimaryButton(
                text = "LinkedIn",
                onClick = { /* Handle LinkedIn via socialLinks.linkedin */ }
            )
        }
        
        Spacer(modifier = Modifier.height(120.dp))
        
        Text(
            text = "© 2026 ${personalInfo.name}. Built with Compose Multiplatform.",
            style = AppTypography.bodyMedium,
            color = AppColors.TextSecondary.copy(alpha = 0.5f)
        )
    }
}
