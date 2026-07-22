package com.asmaa.portfolio.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import com.asmaa.portfolio.feature.home.components.AboutSection
import com.asmaa.portfolio.feature.home.components.ContactSection
import com.asmaa.portfolio.feature.home.components.ExperienceSection
import com.asmaa.portfolio.feature.home.components.HeroSection
import com.asmaa.portfolio.feature.home.components.PortfolioTopBar
import com.asmaa.portfolio.feature.home.components.ProjectsSection
import com.asmaa.portfolio.feature.home.components.SkillsSection
import com.asmaa.portfolio.model.PortfolioData

@Composable
fun HomeSection(
    portfolioData: PortfolioData,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {

        PortfolioTopBar()

        HeroSection(
            personalInfo = portfolioData.personal
        )

        AboutSection(
            personalInfo = portfolioData.personal
        )

        SkillsSection(
            skills = portfolioData.skills
        )

        ExperienceSection(
            experienceList = portfolioData.experience
        )

        ProjectsSection(
            projects = portfolioData.projects
        )

        ContactSection(
            personalInfo = portfolioData.personal,
            socialLinks = portfolioData.social
        )
    }
}
