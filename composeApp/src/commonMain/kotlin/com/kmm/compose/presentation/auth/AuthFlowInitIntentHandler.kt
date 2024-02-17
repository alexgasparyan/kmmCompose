package com.kmm.compose.presentation.auth

import com.kmm.compose.presentation.auth.login.LoginScreen
import com.kmm.compose.presentation.base.IntentHandler
import com.kmm.compose.presentation.base.FlowIntent

class AuthFlowInitIntentHandler : IntentHandler<FlowIntent.Init, AuthFlowModel>() {

    override suspend fun AuthFlowModel.onIntentInternal(intent: FlowIntent.Init) {
        setState { copy(child = LoginScreen) }
    }

    override suspend fun AuthFlowModel.onError(
        intent: FlowIntent.Init,
        exception: Exception
    ) = Unit
}
