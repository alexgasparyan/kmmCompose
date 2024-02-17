package com.kmm.compose.presentation.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow

abstract class Screen<State : Any, Intent : Any, ScreenModel : com.kmm.compose.presentation.base.ScreenModel<State, Intent>> : Screen {

    @Composable
    abstract fun getScreenModel(): ScreenModel

    @Composable
    override fun Content() {
        val screenModel = getScreenModel()
        val state by screenModel.state.collectAsState()
        val navigation by screenModel.navigation.collectAsState(initial = null)
        state.Render(screenModel = screenModel)
        navigation?.let {
            NavigateToInternal(navigationCommand = it)
        }
    }

    @Composable
    private fun NavigateToInternal(navigationCommand: NavigationCommand) {
        val navigator = LocalNavigator.currentOrThrow
        when (navigationCommand) {
            is NavigationCommand.Back -> navigator.pop()
            is NavigationCommand.Replace -> navigator.push(navigationCommand.screen)
            else -> NavigateTo(navigationCommand, navigator)
        }
    }

    @Composable
    open fun NavigateTo(navigationCommand: NavigationCommand, navigator: Navigator) {

    }

    @Composable
    abstract fun State.Render(screenModel: ScreenModel)
}
