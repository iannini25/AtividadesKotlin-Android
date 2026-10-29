package com.bernardo.diariotreinos.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val coresDoApp = lightColorScheme(
    primary = Laranja,
    onPrimary = Branco,
    primaryContainer = LaranjaClaro,
    onPrimaryContainer = Preto,
    secondary = Cinza,
    onSecondary = Branco,
    background = FundoClaro,
    onBackground = Preto,
    surface = FundoClaro,
    onSurface = Preto
)

@Composable
fun TemaTreinos(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = coresDoApp, content = content)
}
