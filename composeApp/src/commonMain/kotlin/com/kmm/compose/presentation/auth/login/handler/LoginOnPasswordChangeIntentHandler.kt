package com.kmm.compose.presentation.auth.login.handler

import com.kmm.compose.presentation.auth.login.LoginIntent
import com.kmm.compose.presentation.auth.login.LoginScreenModel
import com.kmm.compose.presentation.base.IntentHandler

class LoginOnPasswordChangeIntentHandler : IntentHandler<LoginIntent.OnPasswordChange, LoginScreenModel>() {

    override suspend fun LoginScreenModel.onIntentInternal(intent: LoginIntent.OnPasswordChange) {
        setState { copy(password = intent.text) }
    }

    override suspend fun LoginScreenModel.onError(
        intent: LoginIntent.OnPasswordChange,
        exception: Exception
    ) = Unit
}
