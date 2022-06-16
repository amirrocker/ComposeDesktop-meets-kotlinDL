package de.amirrocker.kotlindlmeetscomposedesktop.presentation.weather

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.amirrocker.kotlindlmeetscomposedesktop.data.weather.WeatherInfo
import de.amirrocker.kotlindlmeetscomposedesktop.repository.weather.Repository
import de.amirrocker.kotlindlmeetscomposedesktop.repository.weather.WeatherRepository
import de.amirrocker.kotlindlmeetscomposedesktop.repository.weather.remote.model.WeatherResults
import kotlinx.coroutines.launch

@Composable
fun WeatherScreen(repository: Repository) {

    var weatherState by remember { mutableStateOf<ViewState<WeatherResults>?>(null) }

    val scope = rememberCoroutineScope()

    var queriedCity by remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        TextField(
            value = queriedCity,
            onValueChange = { queriedCity = it },
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 8.dp)
                .weight(1f)
            ,
            placeholder = { Text(text = "Enter city") },
            label = { Text(text = "Search for a city") },
            leadingIcon = { Icon(Icons.Filled.LocationOn, "Location") }
        )
        Button(onClick = {
            println("deal with click")
            weatherState = ViewState.Loading
            scope.launch {
                weatherState = repository.getWeatherForCity(queriedCity)
            }
        }) {
            Icon(Icons.Filled.Search, "Search")
        }
    }
    when(val state = weatherState) {
        is ViewState.Loading -> LoadingUI()
        is ViewState.Error -> error("an error occurred")
        is ViewState.Content -> ContentUI(state.data)
    }
}

@Composable
fun LoadingUI() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator(modifier = Modifier
            .align(alignment = Alignment.Center)
            .defaultMinSize(minWidth = 96.dp, minHeight = 96.dp)
        )
    }
}

@Composable
fun ContentUI(data: WeatherResults) {

    LazyRow {
        items(data.forecast) { weatherInfo ->
            ForecastUI(weatherInfo)
        }
    }
}

@Composable
fun ForecastUI(weatherInfo: WeatherInfo) {
    Text(text = "Info: ${weatherInfo.condition}")
}



@Composable
@Preview
fun WeatherScreenPreview() {
    WeatherScreen(WeatherRepository())
}
