package com.kmm.compose

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.Navigator
import com.kmm.compose.components.DarkColors
import com.kmm.compose.components.LightColors
import com.kmm.compose.di.DependencyInjection
import com.kmm.compose.presentation.RootFlow
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

@Composable
fun App() {
    remember {
        if (BuildParams.isDebug) {
            Napier.base(DebugAntilog())
        }
        DependencyInjection.init()
    }
    val colors = if (isSystemInDarkTheme()) DarkColors else LightColors
    MaterialTheme(colors = colors) {
        Navigator(RootFlow)
    }
}
