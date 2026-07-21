package com.asmaa.portfolio.model

import kotlinx.serialization.Serializable

@Serializable
data class SocialLinks(
    val github: String,
    val linkedin: String,
    val email: String
)
