# My Sports 🏆

A small Android app built with **Jetpack Compose** that lets you browse popular sports, read their rules and leagues, and check sample match scores.

![Kotlin](https://img.shields.io/badge/Kotlin-2.2.10-7F52FF?logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-Material%203-4285F4?logo=jetpackcompose&logoColor=white)
![minSdk](https://img.shields.io/badge/minSdk-24-3DDC84?logo=android&logoColor=white)
![Platform](https://img.shields.io/badge/platform-Android-3DDC84?logo=android&logoColor=white)

---

## 📖 About

**My Sports** is a single-activity Android application written in Kotlin with a fully declarative Compose UI. It demonstrates a typical modern Android setup: Material 3 theming, bottom navigation with `Navigation Compose`, nested (secondary) navigation to a detail screen with arguments, and a clean separation between data, navigation and UI layers.

All sport data is bundled locally in `SportsRepository` — the app works completely offline and needs no permissions.

## ✨ Features

- **Bottom navigation** with four top-level tabs: Home, Account, Profile and My Sports
- **My Sports list** of six sports (Football, Basketball, Soccer, Tennis, Baseball, Volleyball), each with a matching Material icon
- **Sport detail screen** showing category, description, key rules, popular leagues and sample match results
- **Secondary navigation** — the detail screen is pushed onto the back stack, shows a back arrow, and hides the bottom bar
- **Material 3 theming** with light/dark mode and dynamic color (Android 12+)
- **State preservation** — tab state is saved and restored when switching between destinations
- **Offline-first** — no network calls, no permissions, instant load

## 📱 Screens

| Screen | Description |
| --- | --- |
| **Home** | Landing tab with a welcome card and a short intro |
| **Account** | Placeholder tab for account-related content |
| **Profile** | Placeholder tab for the user profile |
| **My Sports** | Scrollable list of sports; tap a card to open its detail page |
| **Sport Detail** | Rules, leagues and sample matches for the selected sport, with a back arrow in the top bar |

> The Account and Profile tabs are intentional placeholders for future work.

## 🛠 Tech stack

| Layer | Technology |
| --- | --- |
| Language | Kotlin 2.2.10 |
| UI toolkit | Jetpack Compose (BOM 2026.02.01), Material 3 |
| Navigation | `androidx.navigation:navigation-compose` 2.8.7 |
| Architecture | Single activity, stateless composables, repository object |
| Build | Gradle 9.9.1 (Kotlin DSL), Android Gradle Plugin 9.5.1 |
| Testing | JUnit 4 (unit tests), Compose UI Test + Espresso (instrumented tests) |

## 📂 Project structure

```
MySports/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/mysports/
│   │   │   │   ├── MainActivity.kt          # Entry point, sets the theme
│   │   │   │   ├── data/
│   │   │   │   │   ├── Sport.kt             # Sport / Match models
│   │   │   │   │   └── SportsRepository.kt  # Static sample data + lookup
│   │   │   │   ├── navigation/
│   │   │   │   │   └── NavDestination.kt    # Screen routes + tab list
│   │   │   │   └── ui/
│   │   │   │       ├── MainScreen.kt        # Scaffold + NavHost
│   │   │   │       ├── components/          # Top bar, bottom bar
│   │   │   │       ├── screens/             # Home, Account, Profile,
│   │   │   │       │                        # MySports, SportDetail
│   │   │   │       └── theme/               # Color, Type, Theme
│   │   │   ├── res/                         # Icons, strings, themes
│   │   │   └── AndroidManifest.xml
│   │   ├── test/                            # JUnit unit tests
│   │   └── androidTest/                     # Compose UI tests
│   └── build.gradle.kts
├── gradle/
│   ├── libs.versions.toml                   # Version catalog
│   └── wrapper/
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## 🚀 Getting started

### Requirements

- [Android Studio](https://developer.android.com/studio) (a version that supports AGP 9.5.1)
- **JDK 17** or newer
- Android SDK Platform **37**
- An emulator or a physical device running **Android 7.0 (API 24)** or newer

### Clone and run

```bash
git clone https://github.com/<your-username>/MySports.git
cd MySports
```

Open the folder in Android Studio and let Gradle sync, or build from the command line:

```bash
# Windows
gradlew.bat assembleDebug

# macOS / Linux
./gradlew assembleDebug
```

Install the debug build on a connected device or running emulator:

```bash
gradlew.bat installDebug     # Windows
./gradlew installDebug       # macOS / Linux
```

Alternatively, just press **Run ▶** in Android Studio.

> `local.properties` is machine-specific and is not committed — Android Studio generates it on first sync.

## 🧪 Testing

```bash
# Unit tests (JVM) — SportsRepository
gradlew.bat testDebugUnitTest

# Instrumented UI tests — navigation flow (requires a device/emulator)
gradlew.bat connectedDebugAndroidTest
```

The test suite covers repository lookups (including case-insensitive IDs and invalid IDs) and verifies the default screen, bottom-tab navigation, and the sport-detail drill-down with back navigation.

## 🗺 Roadmap

- [ ] Replace placeholder Account and Profile tabs with real content
- [ ] Fetch live scores from a sports API (Retrofit + Kotlin Serialization)
- [ ] Add search and filtering by sport category
- [ ] Let users favourite sports and persist them with DataStore
- [ ] Add a screenshot gallery and app icon to this README
- [ ] Add a CI workflow that runs unit tests on every push

## 🤝 Contributing

Contributions, issues and feature requests are welcome. Feel free to open an issue or submit a pull request.

1. Fork the project
2. Create your branch (`git checkout -b feature/my-feature`)
3. Commit your changes (`git commit -m "Add my feature"`)
4. Push (`git push origin feature/my-feature`)
5. Open a pull request

## 📄 License

No license has been added yet. 

---

Built with Kotlin and Jetpack Compose as a learning project for Android development.
