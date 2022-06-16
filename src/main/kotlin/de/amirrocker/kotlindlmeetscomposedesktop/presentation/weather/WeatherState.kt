package de.amirrocker.kotlindlmeetscomposedesktop.presentation.weather

import de.amirrocker.kotlindlmeetscomposedesktop.data.weather.WeatherInfo

data class WeatherState(
    val weatherInfoItems: List<WeatherInfo>
) {

}

sealed class ViewState<out T> {
    object Loading : ViewState<Nothing>()
    data class Content<T>(val data: T) : ViewState<T>()
    data class Error(val error:Throwable) : ViewState<Nothing>()
}
