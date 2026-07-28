package com.asmaa.portfolio.feature.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.asmaa.portfolio.core.navigation.NavigationItem
import com.asmaa.portfolio.core.theme.AppColors
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
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            NavigationItem.entries.filter { it != NavigationItem.HOME }.forEach { item ->
                val isSelected = item == selectedItem
                Text(
                    text = item.label,
                    color = if (isSelected) AppColors.Primary else AppColors.TextSecondary,
                    modifier = Modifier.clickable { onItemClick(item) }
                )
            }
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
                .clickable {}
                .padding(
                    horizontal = 20.dp,
                    vertical = 12.dp
                )
        )
    }
}
@Composable
fun PortfolioLogo(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(Res.drawable.logo),
        contentDescription = "Asmaa Atya Logo",
        modifier = modifier.height(48.dp)
    )
}
