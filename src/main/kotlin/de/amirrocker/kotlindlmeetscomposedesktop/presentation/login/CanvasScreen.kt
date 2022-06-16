package de.amirrocker.kotlindlmeetscomposedesktop.presentation.login

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.unit.dp
import de.amirrocker.kotlindlmeetscomposedesktop.presentation.theme.ColorDark
import de.amirrocker.kotlindlmeetscomposedesktop.presentation.theme.ColorLight
import de.amirrocker.kotlindlmeetscomposedesktop.presentation.theme.ShadowDark
import de.amirrocker.kotlindlmeetscomposedesktop.presentation.theme.ShadowLight


@Composable
fun CanvasScreen(
    modifier: Modifier = Modifier
) {

    Box(modifier=Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(horizontal = 8.dp, vertical = 8.dp)
        .background(
            brush = Brush.linearGradient(
                colors = listOf(
                    ShadowLight,
                    ColorDark
                )
            )
        )
    ) {

//        val deltaXAnim = rememberInfiniteTransition()
//        val dx by deltaXAnim.animateFloat(
//            initialValue = 0f,
//            targetValue = 500f,
//            animationSpec = infiniteRepeatable(
//                animation = tween(10000, easing = LinearEasing)
//            )
//        )
//
//        val animateTranslate by animateFloatAsState(
//            targetValue = 10f,
//            animationSpec = TweenSpec(10000, easing = LinearEasing)
//        )
//
//        val gradient = Brush.verticalGradient(listOf(ColorLight, ColorDark))
//        Canvas(modifier=Modifier.fillMaxWidth().fillMaxHeight()) {
//            translate(top = animateTranslate) {
//                drawRoundRect(
//                    brush = gradient,
//                    size = Size(200f, 200f),
//                    topLeft = Offset(200f, 20f),
//                    cornerRadius = CornerRadius(12f, 12f)
//                )
//            }
//        }

//        GradientView(modifier = modifier
//            .size(30.dp)
//        )


        val gradient = Brush
            .verticalGradient(
                listOf(ColorDark, ShadowDark)
            )
        Canvas(modifier=Modifier.fillMaxWidth().fillMaxHeight()) {
            drawRoundRect(
                brush = gradient,
                size = Size(200f, 200f),
                topLeft = Offset(200f, 20f),
                cornerRadius = CornerRadius(12f, 12f),
            )
            drawRoundRect(
                color = Color.White,
                size = Size(200f, 200f),
                topLeft = Offset(201f, 21f),
                cornerRadius = CornerRadius(12f, 12f),
                style = Stroke(Stroke.HairlineWidth)
            )
        }
    }
}


@Composable
fun GradientView(modifier: Modifier = Modifier) {
    Box(modifier = modifier.verticalGradientBackground(listOf(ColorLight, ColorDark)))
}

fun Modifier.verticalGradientBackground(
    colors:List<Color>
) = drawWithCache {
    val gradient = Brush.verticalGradient(colors)
    onDrawBehind {
        drawRoundRect(brush = gradient, cornerRadius = CornerRadius(12f, 12f) )
    }
}

/*
TrashBin:

//        Canvas(
//            modifier=modifier.size(60.dp)
//                .align(Alignment.Center)
//        ) {
//
//            drawCircle(
//                Brush.linearGradient(
//                    colors = listOf(
//                        ColorLight,
//                        ShadowLight
//                    )
//                ),
//                radius = size.width/2,
//                center = center,
//                style = Stroke(width = size.width * 0.075f)
//            )
//        }

//        Canvas(
//            modifier = Modifier.align(alignment = Alignment.TopCenter)
//        ) {
//            drawRoundRect(
//                brush = Brush.verticalGradient(
//                    colors = listOf(
//                        ColorLight,
//                        ColorDark,
//                    ),
//                    startY = 0.0f,
//                ),
//                size = Size(200f, 200f),
//                topLeft = Offset(0f, 0f),
//                cornerRadius = CornerRadius(12f, 12f)
//            )
//        }


 */








