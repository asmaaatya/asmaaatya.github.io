package com.asmaa.portfolio.feature.home.components

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.asmaa.portfolio.core.components.SecondaryButton
import com.asmaa.portfolio.core.navigation.NavigationItem
import com.asmaa.portfolio.core.theme.AppColors
import com.asmaa.portfolio.core.theme.AppTypography
import org.jetbrains.compose.resources.painterResource
import portfolioapp.shared.generated.resources.Res
import portfolioapp.shared.generated.resources.logo

@Composable
fun PortfolioTopBar(
    selectedItem: NavigationItem,

    onItemClick: (NavigationItem) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(AppColors.Background)
            .border(
                width = 1.dp,
                color = AppColors.Border
            )
            .padding(
                horizontal = 80.dp,
                vertical = 20.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = "ASMAA ATYA",
            style = AppTypography.titleLarge,
            color = AppColors.TextPrimary,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.weight(1f)
        )

        NavigationItem.entries
            .filter {
                it != NavigationItem.HOME
            }
            .forEach { item ->

                Text(
                    text = item.label,
                    modifier = Modifier
                        .clickable {
                            onItemClick(item)
                        }
                        .padding(
                            horizontal = 16.dp,
                            vertical = 8.dp
                        ),
                    color = if (selectedItem == item) {
                        AppColors.Primary
                    } else {
                        AppColors.TextSecondary
                    },
                    style = AppTypography.bodySmall
                )
            }

        Spacer(
            modifier = Modifier.width(20.dp)
        )

        SecondaryButton(
            text = "Download CV",
            onClick = {}
        )
    }
}
@Composable
fun PortfolioLogo(
    modifier: Modifier = Modifier
) {
    // Logo placeholder since Res.drawable.logo might be missing or different
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .height(32.dp)
                .width(32.dp)
                .background(AppColors.Primary, RoundedCornerShape(4.dp))
        )
        Text(
            text = "ASMAA",
            style = AppTypography.titleLarge.copy(fontWeight = FontWeight.Bold),
            color = AppColors.TextPrimary
        )
    }
}
