package com.kmm.compose.presentation

import com.kmm.compose.domain.auth.IsAuthorizedUseCase
import com.kmm.compose.presentation.base.IntentHandler
import com.kmm.compose.presentation.base.FlowIntent
import com.kmm.compose.presentation.auth.AuthFlow
import com.kmm.compose.presentation.main.MainFlow

class RootFlowInitIntentHandler(
    private val isAuthorizedUseCase: IsAuthorizedUseCase
) : IntentHandler<FlowIntent.Init, RootFlowModel>() {

    override suspend fun RootFlowModel.onIntentInternal(intent: FlowIntent.Init) {
        val flow = when (isAuthorizedUseCase()) {
            true -> MainFlow
            false -> AuthFlow
        }
        setState { copy(child = flow) }
    }

    override suspend fun RootFlowModel.onError(
        intent: FlowIntent.Init,
        exception: Exception
    ) = Unit
}
