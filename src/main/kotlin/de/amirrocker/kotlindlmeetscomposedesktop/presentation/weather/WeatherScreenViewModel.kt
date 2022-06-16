package de.amirrocker.kotlindlmeetscomposedesktop.presentation.weather

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class WeatherScreenViewModel {

    sealed class UIEvent {
        data class ShowSnackbar(val message: String) : UIEvent()
    }

    private val _state: MutableState<WeatherState> = mutableStateOf(WeatherState(emptyList()))
    val state: State<WeatherState> = _state

    private val _weatherQuery: MutableState<String> = mutableStateOf("")
    val weatherQuery: State<String> = _weatherQuery

    private val _eventFlow: MutableSharedFlow<UIEvent> = MutableSharedFlow()
    val eventFlow: SharedFlow<UIEvent> = _eventFlow.asSharedFlow()

    private val searchJob:Job? = null

    fun queryWeather(location: String) {

    }


}


