package de.amirrocker.kotlindlmeetscomposedesktop.data.weather

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Current(
    @SerialName("temp_c")
    val tempC : Double,
    val condition: Condition,
    @SerialName("feelslike_c")
    val feelsLikeC: Double
)

@Serializable
data class Condition(
    val text: String,
    val icon: String
)

@Serializable
data class Forecast(
    val forecastDay: List<Forecastday>
)

@Serializable
data class Forecastday(
    val day : Day,
    val hour: List<Hour>
)

@Serializable
data class Day(
    @SerialName("avgtemp_c")
    val avgTempC: Double,
    val condition: Condition
)

@Serializable
data class Hour(
    @SerialName("feelslike_c")
    val feelsLikeC: Double,
    @SerialName("chance_of_rain")
    val chanceOfRain: Int,
)
