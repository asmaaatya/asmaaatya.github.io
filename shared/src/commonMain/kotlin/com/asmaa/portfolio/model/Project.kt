package com.asmaa.portfolio.model

import kotlinx.serialization.Serializable

@Serializable
data class Project(
    val title: String,
    val description: String,
    val technologies: List<String>,
    val github: String,
    val image: String
)
