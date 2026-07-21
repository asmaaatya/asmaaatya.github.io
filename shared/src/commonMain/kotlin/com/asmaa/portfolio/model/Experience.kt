package com.asmaa.portfolio.model

import kotlinx.serialization.Serializable

@Serializable
data class Experience(
    val company: String,
    val position: String,
    val startDate: String,
    val endDate: String,
    val description: String
)
