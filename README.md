# Weather — Android Weather App

A weather app built with **Kotlin**, **Jetpack Compose**, **Clean Architecture**, and **MVVM**.

## 🏗 Architecture

The project follows **Clean Architecture** with an **MVVM** presentation layer:

```
app/
├── data/          # Data sources, DTOs, repository implementations, mappers
├── domain/        # Entities, repository contracts, use cases (pure Kotlin)
└── presentation/  # Compose UI, ViewModels, UI state
```

**The flow:** UI (Compose) → ViewModel → Use Case → Repository → Data Source.

- **Domain layer** is pure Kotlin — no Android or framework dependencies, so it's trivial to unit test.
- **Data layer** implements the repository contracts defined in domain and handles data sources.
- **Presentation layer** exposes UI state from the `ViewModel`, which Compose observes and renders.

## 🛠 Tech Stack

| Area | Choice |
|------|--------|
| Language | Kotlin |
| UI | Jetpack Compose |
| Architecture | Clean Architecture + MVVM |
| Build | Gradle (Kotlin DSL) |
| DI | Koin |
| Networking | Retrofit + OkHttp + Moshi |
| Navigation | Simple Stack |
| Async | Coroutines / Flow |

## 🚀 Getting Started

```bash
# 1. Clone
git clone https://github.com/pogimista/weather-app-2026.git
cd weather-app-2026

# 2. Open in Android Studio (latest stable), let Gradle sync

# 3. Run on an emulator or device
./gradlew installDebug
```

**Requirements:** Android Studio (latest stable), JDK 17+, Android SDK.

---

Built by **John Christopher B. Mista** — Senior/Lead Mobile Engineer (Android Native · iOS · Flutter).
[LinkedIn](https://www.linkedin.com/in/john-christopher-mista) · [GitHub](https://github.com/pogimista)
