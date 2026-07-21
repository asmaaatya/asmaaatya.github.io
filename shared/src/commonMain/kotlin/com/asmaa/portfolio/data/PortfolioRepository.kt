package com.asmaa.portfolio.data

import com.asmaa.portfolio.model.PortfolioData
import kotlinx.serialization.json.Json

class PortfolioRepository {

    private val json = Json {
        ignoreUnknownKeys = true
    }

    fun parsePortfolio(jsonString: String): PortfolioData {
        return json.decodeFromString(jsonString)
    }
}
