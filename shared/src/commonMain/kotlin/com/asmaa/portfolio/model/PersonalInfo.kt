package com.asmaa.portfolio.model

import kotlinx.serialization.Serializable

@Serializable
data class PersonalInfo(
    val name: String,
    val title: String,
    val headline: String,
    val email: String,
    val phone: String,
    val linkedin: String,
    val github: String,
    val location: String
)
