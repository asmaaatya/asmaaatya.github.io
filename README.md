# Portfolio App (Kotlin Multiplatform)

A modern, data-driven portfolio application built with **Compose Multiplatform**, targeting Android and Web.

## 🚀 Current Project State

The application is now a fully functional one-page portfolio with dynamic content loading.

### 🏗 Architecture & Project Structure

The code is organized under `com.asmaa.portfolio` in the `:shared` module, following clean architecture principles:

```text
com.asmaa.portfolio
├── App.kt                 # Main App entry point & Theme wrapper
├── core
│   ├── theme              # Custom colors (AppColors), typography (AppTypography), and AppTheme
│   └── components         # Shared UI components (PortfolioButton, SectionTitle)
├── data
│   └── PortfolioRepository.kt # Kotlinx-serialization logic for JSON parsing
├── model                  # Serializable data models (PortfolioData, PersonalInfo, Skill, etc.)
├── presentation           # State management (PortfolioViewModel, PortfolioState)
└── feature
    └── home               # Home feature entry point (HomeSection.kt)
        └── components     # Feature-specific sections (Hero, About, Skills, Experience, Projects, Contact)
```

### 🛠 Tech Stack

- **Compose Multiplatform**: Declarative UI for Android and Web.
- **Kotlinx Serialization**: JSON decoding for portfolio content.
- **Lifecycle ViewModel**: State management in `commonMain`.
- **Material 3**: Modern design system implementation.
- **Wasm/JS**: High-performance web targets.

### 📄 Data-Driven UI

- **Source of Truth**: `shared/src/commonMain/composeResources/files/portfolio.json` contains all the portfolio details.
- **Dynamic Content**: The UI automatically reflects any changes made to the JSON file, including skill categories, project lists, and work history.
- **Responsive Scrolling**: Optimized for both touch and mouse wheel input using Compose `verticalScroll` and CSS adjustments.

## 📱 How to Run

### Android
```bash
./gradlew :androidApp:assembleDebug
```

### Web
- **Wasm Target**: `./gradlew :webApp:wasmJsBrowserDevelopmentRun`
- **JS Target**: `./gradlew :webApp:jsBrowserDevelopmentRun`

---

## 📅 Roadmap

- [x] Initial Project Reorganization
- [x] Data Models & Serialization Setup
- [x] Portfolio JSON Resource Creation
- [x] Implement UI for all Feature Sections (Hero, About, Skills, Experience, Projects, Contact)
- [x] Data-driven UI integration (ViewModel + JSON)
- [x] Basic scrollability and layout fixes for Web
- [ ] Add Image Loading (Coil-kt/KMP)
- [ ] Advanced Responsive Design (Desktop vs Mobile layouts)
- [ ] Dark/Light Mode toggle
- [ ] Animations & Transitions (Fade-in on scroll)
