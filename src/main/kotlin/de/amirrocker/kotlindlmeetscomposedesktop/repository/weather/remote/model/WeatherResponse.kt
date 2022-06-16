package de.amirrocker.kotlindlmeetscomposedesktop.repository.weather.remote.model

import de.amirrocker.kotlindlmeetscomposedesktop.data.weather.Current
import de.amirrocker.kotlindlmeetscomposedesktop.data.weather.Forecast
import kotlinx.serialization.Serializable

@Serializable
class WeatherResponse(
    val current: Current,
    val forecast: Forecast
)