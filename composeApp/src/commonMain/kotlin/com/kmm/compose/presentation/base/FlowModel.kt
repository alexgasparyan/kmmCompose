package com.kmm.compose.presentation.base

import kotlinx.coroutines.Job

abstract class FlowModel(
    initIntentHandler: IntentHandler<FlowIntent.Init, out FlowModel>
) : ScreenModel<FlowState, FlowIntent>() {

    init {
        registerIntentHandler(initIntentHandler)
        onIntent(FlowIntent.Init)
    }

    override fun getInitialState() = FlowState(child = null)

    final override fun navigate(command: NavigationCommand): Job {
        return super.navigate(command)
    }
}
