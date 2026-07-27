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
import com.asmaa.portfolio.core.navigation.NavigationItem
import com.asmaa.portfolio.core.theme.AppColors
import com.asmaa.portfolio.core.theme.AppTypography
import org.jetbrains.compose.resources.painterResource
import portfolioapp.shared.generated.resources.Res
import portfolioapp.shared.generated.resources.logo

@Composable
fun PortfolioTopBar(
    selectedItem: NavigationItem?,
    onItemClick: (NavigationItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = 24.dp,
                vertical = 20.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        PortfolioLogo(
            modifier = Modifier.clickable { onItemClick(NavigationItem.HOME) }
        )

        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(32.dp)
            ) {
                NavigationItem.entries.filter { it != NavigationItem.HOME }.forEach { item ->
                    val isSelected = item == selectedItem
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.clickable { onItemClick(item) }
                    ) {
                        Text(
                            text = item.label,
                            color = if (isSelected) AppColors.Primary else AppColors.TextSecondary,
                            style = AppTypography.bodyMedium.copy(
                                fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal
                            )
                        )
                        if (isSelected) {
                            Spacer(modifier = Modifier.height(4.dp))
                            Box(
                                modifier = Modifier
                                    .width(12.dp)
                                    .height(2.dp)
                                    .background(AppColors.Primary)
                            )
                        }
                    }
                }
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = AppColors.Border,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .clickable {}
                    .padding(horizontal = 16.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Download CV",
                    color = AppColors.TextPrimary,
                    style = AppTypography.bodyMedium
                )
                Icon(
                    imageVector = Icons.Default.Download,
                    contentDescription = null,
                    tint = AppColors.Primary,
                    modifier = Modifier.size(18.dp)
                )
            }
        }
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
