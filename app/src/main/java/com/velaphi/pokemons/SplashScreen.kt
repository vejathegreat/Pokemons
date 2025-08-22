package com.velaphi.pokemons

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import androidx.compose.ui.res.stringResource

/**
 * Splash screen composable with Pokemon theme and animations.
 * @param onSplashComplete Callback when splash animation is complete
 */
@Composable
fun SplashScreen(
    onSplashComplete: () -> Unit
) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 2000),
        label = "Alpha Animation"
    )

    val scaleAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0.3f,
        animationSpec = tween(durationMillis = 1000),
        label = "Scale Animation"
    )

    val infiniteRotation = rememberInfiniteTransition(label = "Infinite Rotation")
    val continuousRotation by infiniteRotation.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "Continuous Rotation"
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(3000L)
        onSplashComplete()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = androidx.compose.ui.graphics.Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.primaryContainer,
                        MaterialTheme.colorScheme.secondary
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        repeat(6) { index ->
            val angle = (index * 60f + continuousRotation) * (Math.PI / 180f)
            val radius = 200.dp
            val x = (kotlin.math.cos(angle) * radius.value).dp
            val y = (kotlin.math.sin(angle) * radius.value).dp

            // Background Pokemon silhouettes - using a simple circle for now
            Box(
                modifier = Modifier
                    .offset(x = x, y = y)
                    .size(40.dp)
                    .alpha(0.1f)
                    .scale(scaleAnim.value * 0.5f)
                    .background(
                        color = Color.White,
                        shape = CircleShape
                    )
            )
        }

        // Main content
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // App icon with rotation animation - using a colored circle for now
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .scale(scaleAnim.value)
                    .alpha(alphaAnim.value)
                    .background(
                        color = Color.White,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.splash_lightning_emoji),
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontSize = 48.sp
                    ),
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // App name with fade-in animation
            Text(
                text = stringResource(R.string.splash_pokedex_title),
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold
                ),
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .alpha(alphaAnim.value)
                    .scale(scaleAnim.value)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Subtitle with delayed animation
            Text(
                text = stringResource(R.string.splash_catch_em_all),
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                ),
                color = Color.White.copy(alpha = 0.9f),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .alpha(alphaAnim.value)
                    .scale(scaleAnim.value)
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Loading indicator
            androidx.compose.material3.CircularProgressIndicator(
                color = Color.White,
                modifier = Modifier
                    .size(32.dp)
                    .alpha(alphaAnim.value)
            )
        }

        // Floating Pokemon elements
        repeat(3) { index ->
            val delayMs = index * 500
            val infiniteFloat = rememberInfiniteTransition(
                label = stringResource(
                    R.string.splash_float_animation,
                    index
                )
            )
            val floatAnim by infiniteFloat.animateFloat(
                initialValue = -50f,
                targetValue = 50f,
                animationSpec = infiniteRepeatable(
                    animation = tween(2000 + delayMs, easing = EaseInOut),
                    repeatMode = RepeatMode.Reverse
                ),
                label = "Float $index"
            )

            LaunchedEffect(key1 = Unit) {
                delay(delayMs.toLong())
            }

            // Floating Pokemon elements - using colored circles
            Box(
                modifier = Modifier
                    .offset(y = floatAnim.dp)
                    .size(24.dp)
                    .alpha(0.3f)
                    .scale(scaleAnim.value * 0.3f)
                    .offset(
                        x = when (index) {
                            0 -> (-100).dp
                            1 -> 0.dp
                            else -> 100.dp
                        }
                    )
                    .background(
                        color = when (index) {
                            0 -> MaterialTheme.colorScheme.secondary
                            1 -> MaterialTheme.colorScheme.tertiary
                            else -> MaterialTheme.colorScheme.error
                        },
                        shape = CircleShape
                    )
            )
        }
    }
}
