package com.kmm.compose.presentation.base

interface NavigationCommand {

    data object Back : NavigationCommand

    data class Replace(val screen: Screen<*, *, *>) : NavigationCommand
}
