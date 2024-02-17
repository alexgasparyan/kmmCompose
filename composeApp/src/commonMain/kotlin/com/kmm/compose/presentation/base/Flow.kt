package com.kmm.compose.presentation.base

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator

abstract class Flow : Screen<FlowState, FlowIntent, FlowModel>() {

    @Composable
    final override fun NavigateTo(navigationCommand: NavigationCommand, navigator: Navigator) {

    }
}
