package com.kmm.compose.presentation.auth.login.handler

import com.kmm.compose.presentation.auth.login.LoginIntent
import com.kmm.compose.presentation.auth.login.LoginScreenModel
import com.kmm.compose.presentation.base.IntentHandler

class LoginOnUsernameChangeIntentHandler : IntentHandler<LoginIntent.OnUsernameChange, LoginScreenModel>() {

    override suspend fun LoginScreenModel.onIntentInternal(intent: LoginIntent.OnUsernameChange) {
        setState { copy(username = intent.text) }
    }

    override suspend fun LoginScreenModel.onError(
        intent: LoginIntent.OnUsernameChange,
        exception: Exception
    ) = Unit
}
