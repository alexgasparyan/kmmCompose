package com.kmm.compose.components

import androidx.compose.material.Colors

val LightColors = Colors(
    onError = theme_light_onError,
    error = theme_light_error,
    onBackground = theme_light_onBackground,
    background = theme_light_background,
    onSurface = theme_light_onSurface,
    surface = theme_light_surface,
    onSecondary = theme_light_onSecondary,
    secondary = theme_light_secondary,
    onPrimary = theme_light_onPrimary,
    primary = theme_light_primary,
    primaryVariant = theme_light_primary,
    secondaryVariant = theme_light_secondary,
    isLight = true
)

val DarkColors = Colors(
    onError = theme_dark_onError,
    error = theme_dark_error,
    onBackground = theme_dark_onBackground,
    background = theme_dark_background,
    onSurface = theme_dark_onSurface,
    surface = theme_dark_surface,
    onSecondary = theme_dark_onSecondary,
    secondary = theme_dark_secondary,
    onPrimary = theme_dark_onPrimary,
    primary = theme_dark_primary,
    primaryVariant = theme_dark_primary,
    secondaryVariant = theme_dark_secondary,
    isLight = false
)
