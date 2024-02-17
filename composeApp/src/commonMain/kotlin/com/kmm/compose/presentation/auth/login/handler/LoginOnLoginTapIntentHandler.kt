package com.kmm.compose.presentation.auth.login.handler

import com.kmm.compose.domain.auth.AuthUseCase
import com.kmm.compose.presentation.auth.login.LoginIntent
import com.kmm.compose.presentation.auth.login.LoginScreenModel
import com.kmm.compose.presentation.base.IntentHandler
import kotlinx.coroutines.delay

class LoginOnLoginTapIntentHandler(
    private val authUseCase: AuthUseCase
) : IntentHandler<LoginIntent.OnLoginTap, LoginScreenModel>() {

    override suspend fun LoginScreenModel.onIntentInternal(intent: LoginIntent.OnLoginTap) {
        setState { copy(loading = true) }
        delay(2000)
        state.value.apply {
            authUseCase(username = username, password = password)
        }
        setState { copy(loading = false) }
    }

    override suspend fun LoginScreenModel.onError(
        intent: LoginIntent.OnLoginTap,
        exception: Exception
    ) {
        setState { copy(loading = false) }
    }
}
