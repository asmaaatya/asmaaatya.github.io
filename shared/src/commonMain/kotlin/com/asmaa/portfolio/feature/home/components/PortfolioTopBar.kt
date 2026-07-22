package com.asmaa.portfolio.feature.home.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.asmaa.portfolio.core.theme.AppColors

@Composable
fun PortfolioTopBar() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 64.dp,
                vertical = 20.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = "ASMAA.",
            color = AppColors.TextPrimary
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {

            Text(
                text = "About",
                color = AppColors.Primary
            )

            Text(
                text = "Skills",
                color = AppColors.TextSecondary
            )

            Text(
                text = "Experience",
                color = AppColors.TextSecondary
            )

            Text(
                text = "Work",
                color = AppColors.TextSecondary
            )

            Text(
                text = "Contact",
                color = AppColors.TextSecondary
            )
        }

        Text(
            text = "Download CV",
            color = AppColors.Primary,
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = AppColors.Primary,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(
                    horizontal = 20.dp,
                    vertical = 12.dp
                )
        )
    }
}