# Portfolio App (Kotlin Multiplatform)

A modern, data-driven portfolio application built with **Compose Multiplatform**, targeting Android and Web.

## 🚀 Key Features

- **Full-Screen Snapping**: A seamless, section-by-section browsing experience using `SnapFlingBehavior`. Each part of the portfolio occupies exactly one screen height.
- **Section Anchoring**: The top navigation bar automatically highlights the active section as you scroll or snap through the page.
- **Nested Scrolling**: Smart handling of long content. Sections like *Experience* and *Projects* allow internal vertical scrolling before snapping to the next section.
- **Interactive Call-to-Actions**: Functional buttons for "View My Work" (auto-scrolls to projects), LinkedIn profiles, and one-click Email messaging.
- **Data-Driven UI**: Entire portfolio content is managed via a single JSON resource, making updates trivial without touching UI code.

### 🏗 Architecture & Project Structure

The project follows Clean Architecture principles with a modular feature-based structure in the `:shared` module:

```text
com.asmaa.portfolio
├── App.kt                 # Main App entry point & Theme wrapper
├── core
│   ├── theme              # Custom colors (AppColors), typography (AppTypography), and AppTheme
│   ├── components         # Shared UI components (PortfolioButton, SectionTitle)
│   └── navigation         # Navigation models (NavigationItem)
├── data
│   └── PortfolioRepository.kt # Kotlinx-serialization logic for JSON parsing
├── model                  # Serializable data models (PortfolioData, PersonalInfo, About, etc.)
├── presentation           # State management (PortfolioViewModel, PortfolioState)
└── feature                # Modular UI features
    ├── home               # Home entry point & Section orchestrator
    ├── about              # About section UI
    ├── skills             # Tech stack grid
    ├── experience         # Work history with internal scrolling
    ├── projects           # Featured work gallery with internal scrolling
    ├── education          # Academic background
    └── contact            # Social links & footer
```

### 🛠 Tech Stack

- **Compose Multiplatform**: Declarative UI across Android and Web.
- **Kotlinx Serialization**: Type-safe JSON decoding for portfolio content.
- **Lifecycle ViewModel**: Consistent state management in `commonMain`.
- **SnapFlingBehavior**: Custom snapping logic for a paginated feel.
- **LocalUriHandler**: Platform-agnostic handling of external links (Web/Mobile).
- **Wasm/JS**: High-performance web targets.

## 📄 Data Management

- **Source of Truth**: `shared/src/commonMain/composeResources/files/portfolio.json`.
- **Flexibility**: The UI automatically adapts to changes in the JSON, including adding new project highlights or experience bullet points.

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
- [x] Comprehensive JSON Content Update
- [x] Implement Full-Screen Snapping & Scrolling
- [x] Implement Section Anchoring & Navigation Highlighting
- [x] Add Education & Rich Experience Details
- [x] Interactive Link Handling
- [ ] Add Image Loading (Coil-kt/KMP)
- [ ] Advanced Responsive Design (Desktop vs Mobile layouts)
- [ ] Dark/Light Mode toggle
- [ ] Scroll-triggered Animations (Fade-ins)
