package com.asmaa.portfolio.model

import kotlinx.serialization.Serializable

@Serializable
data class Education(
    val degree: String,
    val university: String,
    val location: String,
    val grade: String,
    val startDate: String,
    val endDate: String
)
