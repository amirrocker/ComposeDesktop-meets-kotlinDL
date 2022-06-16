package de.amirrocker.kotlindlmeetscomposedesktop.repository.weather.remote

import de.amirrocker.kotlindlmeetscomposedesktop.data.weather.Forecastday
import de.amirrocker.kotlindlmeetscomposedesktop.data.weather.Hour
import de.amirrocker.kotlindlmeetscomposedesktop.data.weather.WeatherInfo
import de.amirrocker.kotlindlmeetscomposedesktop.repository.weather.remote.model.WeatherResponse
import de.amirrocker.kotlindlmeetscomposedesktop.repository.weather.remote.model.WeatherResults

class WeatherTransformer {

    fun transform(response:WeatherResponse): WeatherResults = WeatherResults(
            currentWeather = extractCurrentWeatherFrom(response),
            forecast = extractForecastWeatherFrom(response)
    )

    // this is the current weather
    private fun extractCurrentWeatherFrom(response:WeatherResponse):WeatherInfo = WeatherInfo(
            condition = response.current.condition.text,
            iconUrl = "Https:" + response.current.condition.icon, // replace with 128er size
            temperature = response.current.tempC,
            feelsLike = response.current.feelsLikeC,
        )

    // a list of forecasts
    private fun extractForecastWeatherFrom(response:WeatherResponse) =
        response.forecast.forecastDay.map { forecastDay ->
            println("forecast day: $forecastDay")
            WeatherInfo(
                condition = forecastDay.day.condition.text,
                iconUrl = "Https:" + forecastDay.day.condition.icon, // replace with 128er size
                temperature = forecastDay.day.avgTempC,
                feelsLike = avgFeelsLike(forecastDay),
                chanceOfRain = avgChanceOfRain(forecastDay)
            )
        }

    private fun avgFeelsLike(forecastDay: Forecastday):Double = forecastDay.hour.map(Hour::feelsLikeC).average()
    private fun avgChanceOfRain(forecastDay: Forecastday):Double = forecastDay.hour.map(Hour::chanceOfRain).average()

}