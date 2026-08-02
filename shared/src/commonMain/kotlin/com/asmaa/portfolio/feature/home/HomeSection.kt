package com.asmaa.portfolio.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.asmaa.portfolio.core.navigation.NavigationItem
import com.asmaa.portfolio.core.theme.AppColors
import com.asmaa.portfolio.feature.about.AboutSection
import com.asmaa.portfolio.feature.contact.ContactSection
import com.asmaa.portfolio.feature.experience.ExperienceSection
import com.asmaa.portfolio.feature.home.components.HeroSection
import com.asmaa.portfolio.feature.home.components.PortfolioTopBar
import com.asmaa.portfolio.feature.projects.ProjectsSection
import com.asmaa.portfolio.feature.skills.SkillsSection
import com.asmaa.portfolio.model.PortfolioData
import kotlinx.coroutines.launch

@Composable
fun HomeSection(
    portfolioData: PortfolioData,
    modifier: Modifier = Modifier
) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    var selectedItem by remember {
        mutableStateOf(NavigationItem.HOME)
    }

    val sectionIndexes = mapOf(
        NavigationItem.HOME to 0,
        NavigationItem.ABOUT to 1,
        NavigationItem.SKILLS to 2,
        NavigationItem.EXPERIENCE to 3,
        NavigationItem.WORK to 4,
        NavigationItem.CONTACT to 5
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AppColors.Background)
    ) {
        PortfolioTopBar(
            selectedItem = selectedItem,
            onItemClick = { item ->
                selectedItem = item

                val index = sectionIndexes[item]
                    ?: return@PortfolioTopBar

                coroutineScope.launch {
                    listState.animateScrollToItem(index)
                }
            }
        )

        Box(
            modifier = Modifier.weight(1f)
        ) {
            LazyColumn(
                state = listState,
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    HeroSection(
                        personalInfo = portfolioData.personal,
                        onViewMyWorkClick = {
                            selectedItem = NavigationItem.WORK
                            coroutineScope.launch {
                                listState.animateScrollToItem(4)
                            }
                        }
                    )
                }

                item {
                    AboutSection(
                        about = portfolioData.about,
                        personalInfo = portfolioData.personal
                    )
                }

                item {
                    SkillsSection(
                        skills = portfolioData.skills
                    )
                }

                item {
                    ExperienceSection(
                        experienceList = portfolioData.experience
                    )
                }

                item {
                    ProjectsSection(
                        projects = portfolioData.projects
                    )
                }

                item {
                    ContactSection(
                        personalInfo = portfolioData.personal,
                        socialLinks = portfolioData.social,
                        onBackToTopClick = {
                            coroutineScope.launch {
                                listState.animateScrollToItem(0)
                            }
                        },
                        onEmailClick = {
                            // TODO: Open email client
                        },
                        onLinkedInClick = {
                            // TODO: Open LinkedIn profile
                        },
                        onGitHubClick = {
                            // TODO: Open GitHub profile
                        }
                    )
                }
            }
        }
    }
}