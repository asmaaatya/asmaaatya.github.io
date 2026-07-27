# Fix Navigation Issues

The user reported that the "Contact" navigation is "not correct". Based on the current implementation, several navigation elements are currently non-functional:
1. **Footer Links**: The navigation links in the footer of `ContactSection` have empty click listeners.
2. **Back to Top**: The "Back to Top" button in the footer has an empty click listener.
3. **Hero CTA**: The "View My Work" button in the `HeroSection` has an empty click listener.
4. **Scroll Awareness**: The TopBar does not automatically update its active state as the user scrolls.

## Proposed Changes

### [Component] Navigation & Feature Sections

#### [MODIFY] [HeroSection.kt](file:///D:/android/PortfolioAppKmp/shared/src/commonMain/kotlin/com/asmaa/portfolio/feature/home/components/HeroSection.kt)
- Add an `onViewWorkClick: () -> Unit` callback.
- Connect the "View My Work" button to this callback.

#### [MODIFY] [ContactSection.kt](file:///D:/android/PortfolioAppKmp/shared/src/commonMain/kotlin/com/asmaa/portfolio/feature/contact/ContactSection.kt)
- Add `onNavItemClick: (NavigationItem) -> Unit` and `onBackToTopClick: () -> Unit` callbacks.
- Connect footer links and the "Back to top" button.

#### [MODIFY] [HomeSection.kt](file:///D:/android/PortfolioAppKmp/shared/src/commonMain/kotlin/com/asmaa/portfolio/feature/home/HomeSection.kt)
- Implement scroll-aware section tracking using `derivedStateOf` to update the active `NavigationItem` in the TopBar.
- Pass the new callbacks to `HeroSection` and `ContactSection`.
- Ensure all navigation triggers (TopBar, Hero, Footer) perform the correct animated scroll.

## Verification Plan

### Manual Verification
- **Functional Navigation**: Test all navigation points:
    - TopBar links.
    - "View My Work" button in the Hero section.
    - Footer links in the Contact section.
    - "Back to Top" button.
- **Scroll Highlighting**: Verify that the TopBar correctly highlights the section currently in view during manual scrolling.
