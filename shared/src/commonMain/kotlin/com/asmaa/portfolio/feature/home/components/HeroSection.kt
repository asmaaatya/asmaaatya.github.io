package com.asmaa.portfolio.feature.home.components

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
import com.asmaa.portfolio.core.components.SecondaryButton
import com.asmaa.portfolio.core.theme.AppColors
import com.asmaa.portfolio.core.theme.AppTypography
import com.asmaa.portfolio.model.PersonalInfo

@Composable
fun HeroSection(
    personalInfo: PersonalInfo
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 80.dp,
                vertical = 80.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = "HELLO, I'M",
                color = AppColors.Primary,
                style = AppTypography.labelLarge
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Text(
                text = personalInfo.name,
                style = AppTypography.displayLarge
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = personalInfo.title,
                style = AppTypography.headlineMedium
            )

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            Text(
                text = "Android  •  Flutter  •  Kotlin  •  Jetpack Compose",
                color = AppColors.Primary,
                style = AppTypography.bodyLarge
            )

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            Text(
                text = personalInfo.headline,
                style = AppTypography.bodyLarge
            )

            Spacer(
                modifier = Modifier.height(32.dp)
            )

            HeroButtons()
        }

        Spacer(
            modifier = Modifier.weight(0.3f)
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
