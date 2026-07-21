package com.asmaa.portfolio.model

import kotlinx.serialization.Serializable

@Serializable
data class PersonalInfo(
    val name: String,
    val title: String,
    val description: String,
    val location: String
)
