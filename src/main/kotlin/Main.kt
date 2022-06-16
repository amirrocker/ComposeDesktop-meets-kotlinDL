// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import de.amirrocker.fantasticadventure.kotlindl.testKotlinDL
import de.amirrocker.kotlindlmeetscomposedesktop.presentation.login.CanvasScreen
import de.amirrocker.kotlindlmeetscomposedesktop.presentation.login.SignInScreen
import de.amirrocker.kotlindlmeetscomposedesktop.presentation.theme.KotlinDLMeetsComposeTheme
import de.amirrocker.kotlindlmeetscomposedesktop.presentation.weather.WeatherScreen
import de.amirrocker.kotlindlmeetscomposedesktop.presentation.weather.WeatherScreenViewModel
import de.amirrocker.kotlindlmeetscomposedesktop.repository.weather.WeatherRepository
import kotlinx.coroutines.flow.collectLatest


/**
 * looking into a compose tutorial
 * https://www.raywenderlich.com/26791460-compose-for-desktop-get-your-weather#toc-anchor-001
 */

@Composable
@Preview
fun App() {

//    DesktopMaterialTheme {
    KotlinDLMeetsComposeTheme {
//        Button(onClick = {
//            text = "Hello, Desktop!"
//        }) {
//            Text(text)
//        }

        var text by remember { mutableStateOf("Hello, World!") }
        // look compose di container
        val viewModel = WeatherScreenViewModel()
        val state = viewModel.state.value
        val scaffoldState = rememberScaffoldState()


        LaunchedEffect(true) {
            viewModel.eventFlow.collectLatest {
                when(it) {
                    is WeatherScreenViewModel.UIEvent.ShowSnackbar -> {
                        scaffoldState.snackbarHostState.showSnackbar(message = it.message)
                    }
                }
            }
        }

        testKotlinDL()

        Scaffold(
            scaffoldState = scaffoldState
        ) {
            Box(modifier = Modifier
                .background(MaterialTheme.colors.background)
            ) {


//                WeatherScreen(WeatherRepository())

//                SignInScreen()

//                CanvasScreen()
            }
        }

    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
