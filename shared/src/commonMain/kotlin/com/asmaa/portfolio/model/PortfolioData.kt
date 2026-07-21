package com.asmaa.portfolio.model

import kotlinx.serialization.Serializable

@Serializable
data class PortfolioData(
    val personal: PersonalInfo,
    val social: SocialLinks,
    val skills: List<String>,
    val experience: List<Experience>,
    val projects: List<Project>
)
