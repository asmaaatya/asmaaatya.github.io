package com.asmaa.portfolio.model

import kotlinx.serialization.Serializable


@Serializable
data class Skill(
    val title: String,
    val skills: List<String>
)
