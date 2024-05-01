# Food Items

## Description
Food Item is an Android app developed using Kotlin and Jetpack Compose. It allows users to browse food items fetched from TheMealDB API and view them in a grid layout.

## Features
- Fetch food items from TheMealDB API.
- Display food items in a grid layout.
- Get an error message if there is an issue with your internet connection.

## Installation
1. Clone the repository.
2. Open the project in Android Studio.
3. Build and run the app on an emulator or physical device.

## Dependencies
- Kotlin: Kotlin is the primary programming language used in this project.
- Jetpack Compose: Jetpack Compose is used for building the UI of the app.
- Retrofit: Retrofit is used for making API calls to TheMealDB API.
- Gson: Google's Gson library provides a powerful framework for converting between JSON strings and Kotlin objects.
- Coil: Coil is used for loading images from URLs.

## Copy these below implementations in your build.gradle.kts file:
- For Compose ViewModel: implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
- For network calls to TheMealDB: implementation("com.squareup.retrofit2:retrofit:2.6.2")
- For JSON to Kotlin object mapping: implementation("com.squareup.retrofit2:converter-gson:2.6.2")
- For image loading: implementation("io.coil-kt:coil-compose:2.4.0")
    

## Usage
Upon launching the app, users will be presented with a grid view of food items fetched from TheMealDB API. They can scroll through the grid to explore different food items.

## API Documentation
TheMealDB API documentation can be found at [TheMealDB API Documentation](https://www.themealdb.com/api.php).

## Contributing
Contributions are welcome. If you would like to contribute to this project, please fork the repository and submit a pull request.



