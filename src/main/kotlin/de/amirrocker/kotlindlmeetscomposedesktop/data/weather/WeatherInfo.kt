package de.amirrocker.kotlindlmeetscomposedesktop.data.weather

typealias WeatherCondition = String
typealias IconUrl = String
typealias Temperature = Double
typealias FeelsLike = Double
typealias ChanceOfRain = Double?

data class WeatherInfo(
    val condition: WeatherCondition,
    val iconUrl: IconUrl,
    val temperature: Temperature,
    val feelsLike: FeelsLike,
    val chanceOfRain: ChanceOfRain = null,
)