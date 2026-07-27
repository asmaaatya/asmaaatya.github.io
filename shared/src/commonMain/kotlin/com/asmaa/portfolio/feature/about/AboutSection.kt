package com.asmaa.portfolio.feature.about

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
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Devices
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asmaa.portfolio.core.theme.AppColors
import com.asmaa.portfolio.core.theme.AppTypography
import com.asmaa.portfolio.model.About
import com.asmaa.portfolio.model.PersonalInfo

@Composable
fun AboutSection(
    about: About,
    personalInfo: PersonalInfo
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 80.dp,
                vertical = 100.dp
            )
    ) {
        Text(
            text = "ABOUT ME",
            color = AppColors.Primary,
            style = AppTypography.labelLarge
        )

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Building meaningful\nmobile experiences.",
                    style = AppTypography.displayMedium
                )
                
                Spacer(modifier = Modifier.height(40.dp))
                
                // Know More Button
                Box(
                    modifier = Modifier
                        .border(1.dp, AppColors.TextPrimary, RoundedCornerShape(8.dp))
                        .clickable {}
                        .padding(horizontal = 24.dp, vertical = 12.dp)
                ) {
                    Text(
                        text = "Know More About Me",
                        style = AppTypography.bodyMedium,
                        color = AppColors.TextPrimary
                    )
                }
            }

            Spacer(modifier = Modifier.width(80.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = about.description,
                    style = AppTypography.bodyLarge,
                    color = AppColors.TextSecondary
                )
            }
        }

        Spacer(modifier = Modifier.height(80.dp))

        AboutStats()
    }
}

@Composable
private fun AboutStats() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        StatCard(
            value = "3+",
            label = "Years of\nExperience",
            icon = Icons.Default.Timeline,
            modifier = Modifier.weight(1f)
        )

        StatCard(
            value = "15+",
            label = "Projects\nCompleted",
            icon = Icons.Default.AutoAwesome,
            modifier = Modifier.weight(1f)
        )

        StatCard(
            value = "2",
            label = "Platforms\n(Android & iOS)",
            icon = Icons.Default.Devices,
            modifier = Modifier.weight(1f)
        )

        StatCard(
            value = "Happy",
            label = "Clients & Users",
            icon = Icons.Default.Group,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun StatCard(
    value: String,
    label: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(AppColors.Surface, RoundedCornerShape(16.dp))
            .border(1.dp, AppColors.Border, RoundedCornerShape(16.dp))
            .padding(32.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = AppColors.Primary,
            modifier = Modifier.size(32.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = value,
            style = AppTypography.displayLarge.copy(fontSize = 40.sp, lineHeight = 48.sp),
            color = AppColors.TextPrimary
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = label,
            style = AppTypography.bodyMedium,
            color = AppColors.TextSecondary
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Box(
            modifier = Modifier
                .width(24.dp)
                .height(2.dp)
                .background(AppColors.Primary)
        )
    }
}
