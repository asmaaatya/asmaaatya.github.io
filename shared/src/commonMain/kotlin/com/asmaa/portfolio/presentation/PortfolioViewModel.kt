package com.asmaa.portfolio.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asmaa.portfolio.data.PortfolioRepository
import com.asmaa.portfolio.model.PortfolioData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import portfolioapp.shared.generated.resources.Res

class PortfolioViewModel : ViewModel() {
    private val repository = PortfolioRepository()
    
    private val _uiState = MutableStateFlow<PortfolioState>(PortfolioState.Loading)
    val uiState: StateFlow<PortfolioState> = _uiState.asStateFlow()

    init {
        loadPortfolio()
    }

    private fun loadPortfolio() {
        viewModelScope.launch {
            try {
                @OptIn(ExperimentalResourceApi::class)
                val bytes = Res.readBytes("files/portfolio.json")
                val jsonString = bytes.decodeToString()
                val data = repository.parsePortfolio(jsonString)
                _uiState.value = PortfolioState.Success(data)
            } catch (e: Exception) {
                _uiState.value = PortfolioState.Error(e.message ?: "Unknown error")
            }
        }
    }
}

sealed class PortfolioState {
    object Loading : PortfolioState()
    data class Success(val data: PortfolioData) : PortfolioState()
    data class Error(val message: String) : PortfolioState()
}
