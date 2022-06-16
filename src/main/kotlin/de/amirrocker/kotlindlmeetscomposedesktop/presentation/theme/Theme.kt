package de.amirrocker.kotlindlmeetscomposedesktop.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import jetbrains.datalore.base.values.Color

private val DarkColorPalette = darkColors(
    primary = Red100,
    secondary = Blue100,
    primaryVariant = Green100,
    secondaryVariant = Orange100
)

private val LightColorPalette = lightColors(
    primary = Red100,
    secondary = Blue100,
    primaryVariant = Green100,
    secondaryVariant = Orange100
)


@Composable
fun KotlinDLMeetsComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if(darkTheme) {
        LightColorPalette
//        DarkColorPalette
    } else {
        LightColorPalette
    }
    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}