package com.asmaa.portfolio

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.tooling.preview.Preview
import com.asmaa.portfolio.core.theme.AppColors
import com.asmaa.portfolio.core.theme.AppTheme
import com.asmaa.portfolio.feature.home.HomeSection
import com.asmaa.portfolio.presentation.PortfolioState
import com.asmaa.portfolio.presentation.PortfolioViewModel

@Composable
@Preview
fun App() {
    AppTheme {
        val viewModel: PortfolioViewModel = viewModel { PortfolioViewModel() }
        val state by viewModel.uiState.collectAsStateWithLifecycle()

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = AppColors.Background
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                when (val currentState = state) {
                    is PortfolioState.Loading -> {
                        CircularProgressIndicator(color = AppColors.Primary)
                    }
                    is PortfolioState.Success -> {
                        HomeSection(portfolioData = currentState.data)
                    }
                    is PortfolioState.Error -> {
                        Text(
                            text = "Error: ${currentState.message}",
                            color = AppColors.TextPrimary
                        )
                    }
                }
            }
        }
    }
}
