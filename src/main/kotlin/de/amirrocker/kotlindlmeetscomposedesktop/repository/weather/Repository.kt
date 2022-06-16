package de.amirrocker.kotlindlmeetscomposedesktop.repository.weather

import de.amirrocker.kotlindlmeetscomposedesktop.data.weather.Condition
import de.amirrocker.kotlindlmeetscomposedesktop.data.weather.Current
import de.amirrocker.kotlindlmeetscomposedesktop.data.weather.Day
import de.amirrocker.kotlindlmeetscomposedesktop.data.weather.Forecast
import de.amirrocker.kotlindlmeetscomposedesktop.data.weather.Forecastday
import de.amirrocker.kotlindlmeetscomposedesktop.data.weather.Hour
import de.amirrocker.kotlindlmeetscomposedesktop.presentation.weather.ViewState
import de.amirrocker.kotlindlmeetscomposedesktop.repository.weather.remote.WeatherTransformer
import de.amirrocker.kotlindlmeetscomposedesktop.repository.weather.remote.model.WeatherResponse
import de.amirrocker.kotlindlmeetscomposedesktop.repository.weather.remote.model.WeatherResults

interface Repository {

    suspend fun getWeatherForCity(city: String): ViewState<WeatherResults>

}

class WeatherRepository : Repository {

    private val transformer = WeatherTransformer()

    override suspend fun getWeatherForCity(city: String): ViewState<WeatherResults> = try {
        val response = weatherForCity(city)
        val content = transformer.transform(response = response)
        ViewState.Content(content)
    } catch (ex: Exception) {
        error(ex)
        ViewState.Error(ex)
    }


    private suspend fun weatherForCity(city: String): WeatherResponse {
        return WeatherResponse(
            current = Current(
                tempC = 32.0,
                condition = Condition(
                    text = "Condition is nice",
                    icon = "someIcon"
                ),
                feelsLikeC = 44.9
            ),
            forecast = Forecast(
                listOf(
                    Forecastday(
                        day = Day(avgTempC = 21.3, condition = Condition(
                            text = "Breezy with sunshine",
                            icon = "someIcon"
                        )),
                        hour = (0..23).map {
                            Hour(
                                feelsLikeC = 24.9,
                                chanceOfRain = 64
                            )
                        }
                    ),
                    Forecastday(
                        day = Day(avgTempC = 21.3, condition = Condition(
                            text = "Rainy with light Storms",
                            icon = "someIcon"
                        )),
                        hour = (0..23).map {
                            Hour(
                                feelsLikeC = 24.9,
                                chanceOfRain = 64
                            )
                        }
                    ),
                )
            )
        )
    }
}
