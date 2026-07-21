# Portfolio App (Kotlin Multiplatform)

A modern portfolio application built with **Compose Multiplatform**, targeting Android and Web.

## 🚀 Current Project State

The project is currently in the foundational stage, with the core architecture and data layer established.

### 🏗 Architecture & Project Structure

The code is organized under `com.asmaa.portfolio` in the `:shared` module:

```text
com.asmaa.portfolio
├── App.kt                 # Main App entry point
├── core
│   ├── theme              # App colors, typography, and theme wrapper
│   └── components         # Reusable UI components (SectionTitle, PrimaryButton)
├── data
│   └── PortfolioRepository.kt # Handles JSON data parsing
├── model                  # Serializable data models (PersonalInfo, Project, Experience, etc.)
└── feature                # UI Sections (Home, About, Skills, Experience, Projects, Contact)
```

### 🛠 Tech Stack

- **Compose Multiplatform**: For building declarative UI across Android and Web.
- **Kotlinx Serialization**: Used for parsing portfolio data from JSON.
- **Gradle Version Catalog**: For centralized dependency management.

### 📄 Data Management

- **Resource File**: `shared/src/commonMain/composeResources/files/portfolio.json` contains the source of truth for the portfolio content.
- **Repository**: `PortfolioRepository` uses `kotlinx-serialization` to decode the JSON into structured Kotlin objects.

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
- [ ] Implement UI for each Feature Section
- [ ] Add Image Loading with Coil
- [ ] Responsive Layout for Web/Mobile
- [ ] Dark Mode Support
