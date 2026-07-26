package com.asmaa.portfolio.model

import kotlinx.serialization.Serializable

@Serializable
data class PortfolioData(
    val personal: PersonalInfo,
    val about: About,
    val skills: List<Skill>,
    val experience: List<Experience>,
    val projects: List<Project>,
    val education: Education,
    val social: SocialLinks
)
