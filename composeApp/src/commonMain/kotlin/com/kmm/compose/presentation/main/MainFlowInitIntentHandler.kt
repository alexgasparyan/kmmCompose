package com.kmm.compose.presentation.main

import com.kmm.compose.presentation.base.IntentHandler
import com.kmm.compose.presentation.base.FlowIntent

class MainFlowInitIntentHandler : IntentHandler<FlowIntent.Init, MainFlowModel>() {

    override suspend fun MainFlowModel.onIntentInternal(intent: FlowIntent.Init) {
        // todo show main screen whatever it is
        //setState { copy(child = Auth) }
    }

    override suspend fun MainFlowModel.onError(
        intent: FlowIntent.Init,
        exception: Exception
    ) = Unit
}
