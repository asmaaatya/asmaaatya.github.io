# Implementation Plan - Advanced Features & Polishing

This plan covers the implementation of high-end features to elevate the portfolio's UX, including image loading, responsive design, theme switching, and scroll animations.

## User Review Required

> [!IMPORTANT]
> I will be adding **Coil 3** for image loading. This requires adding new dependencies to your `libs.versions.toml` and updating the `:shared` module configuration.

> [!NOTE]
> For **Responsive Design**, I will implement a system that detects "Compact" (Mobile) vs "Expanded" (Desktop) layouts. This will change how sections like `Hero` and `About` are structured (e.g., swapping from `Row` to `Column`).

## Proposed Changes

### 1. Dependencies & Infrastructure

#### [MODIFY] [libs.versions.toml](file:///D:/android/PortfolioAppKmp/gradle/libs.versions.toml)
- Add `coil3 = "3.0.0-alpha06"` (or latest stable for KMP).
- Add `androidx-material3-windowSizeClass`.

#### [MODIFY] [shared/build.gradle.kts](file:///D:/android/PortfolioAppKmp/shared/build.gradle.kts)
- Add Coil and WindowSizeClass dependencies to `commonMain`.

### 2. Theme & Dark/Light Mode

#### [MODIFY] [AppColors.kt](file:///D:/android/PortfolioAppKmp/shared/src/commonMain/kotlin/com/asmaa/portfolio/core/theme/AppColors.kt)
- Define a full `Light` color palette alongside the existing `Dark` one.

#### [MODIFY] [AppTheme.kt](file:///D:/android/PortfolioAppKmp/shared/src/commonMain/kotlin/com/asmaa/portfolio/core/theme/AppTheme.kt)
- Update `AppTheme` to accept a `useDarkTheme: Boolean` parameter.

#### [MODIFY] [PortfolioViewModel.kt](file:///D:/android/PortfolioAppKmp/shared/src/commonMain/kotlin/com/asmaa/portfolio/presentation/PortfolioViewModel.kt)
- Add a `isDarkTheme` StateFlow to manage global theme state.

### 3. Responsive Design

#### [NEW] [WindowSize.kt](file:///D:/android/PortfolioAppKmp/shared/src/commonMain/kotlin/com/asmaa/portfolio/core/theme/WindowSize.kt)
- Create a utility to provide current screen size categories to the UI.

#### [MODIFY] [HomeSection.kt](file:///D:/android/PortfolioAppKmp/shared/src/commonMain/kotlin/com/asmaa/portfolio/feature/home/HomeSection.kt)
- Wrap the UI in `BoxWithConstraints` to pass sizing info down.

### 4. Image Loading (Coil-kt/KMP)

#### [MODIFY] [Project.kt](file:///D:/android/PortfolioAppKmp/shared/src/commonMain/kotlin/com/asmaa/portfolio/model/Project.kt)
- Add an `imageUrl` field.

#### [MODIFY] [ProjectsSection.kt](file:///D:/android/PortfolioAppKmp/shared/src/commonMain/kotlin/com/asmaa/portfolio/feature/projects/ProjectsSection.kt)
- Integrate `AsyncImage` from Coil to display project thumbnails.

### 5. Scroll-triggered Animations

#### [NEW] [ScrollAnimation.kt](file:///D:/android/PortfolioAppKmp/shared/src/commonMain/kotlin/com/asmaa/portfolio/core/components/ScrollAnimation.kt)
- Create a wrapper component using `AnimatedVisibility` or `Modifier.graphicsLayer` that triggers a fade-in when its section becomes visible in the `LazyColumn`.

## Verification Plan

### Automated Tests
- Run `:shared:assemble` to ensure all new dependencies and code changes compile across platforms.

### Manual Verification
- Deploy to Web:
    - Toggle the Theme switch in the TopBar.
    - Resize the browser window to see the layout switch between Mobile and Desktop modes.
    - Scroll through the page to verify sections fade in as they appear.
    - Check that project images load correctly (using placeholder URLs initially).
