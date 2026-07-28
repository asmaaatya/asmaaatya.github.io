package com.asmaa.portfolio.model

import kotlinx.serialization.Serializable

@Serializable
data class Project(
    val name: String,
    val category: String,
    val technologies: List<String>,
    val description: String,
    val highlights: List<String>,
    val links: ProjectLinks
)

@Serializable
data class ProjectLinks(
    val playStore: String? = null,
    val appStore: String? = null,
    val github: String? = null
)
