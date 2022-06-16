package de.amirrocker.kotlindlmeetscomposedesktop.repository.weather.remote.model

import de.amirrocker.kotlindlmeetscomposedesktop.data.weather.WeatherInfo

data class WeatherResults(
    val currentWeather : WeatherInfo,
    val forecast: List<WeatherInfo>,
)


