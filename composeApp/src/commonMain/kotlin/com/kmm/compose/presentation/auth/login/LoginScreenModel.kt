package com.kmm.compose.presentation.auth.login

import com.kmm.compose.presentation.auth.login.handler.LoginOnLoginTapIntentHandler
import com.kmm.compose.presentation.auth.login.handler.LoginOnPasswordChangeIntentHandler
import com.kmm.compose.presentation.auth.login.handler.LoginOnUsernameChangeIntentHandler
import com.kmm.compose.presentation.base.ScreenModel

class LoginScreenModel(
    onUsernameChangeIntentHandler: LoginOnUsernameChangeIntentHandler,
    onPasswordChangeIntentHandler: LoginOnPasswordChangeIntentHandler,
    onLoginTapIntentHandler: LoginOnLoginTapIntentHandler
) : ScreenModel<LoginState, LoginIntent>() {

    init {
        registerIntentHandler(onUsernameChangeIntentHandler)
        registerIntentHandler(onPasswordChangeIntentHandler)
        registerIntentHandler(onLoginTapIntentHandler)
    }

    override fun getInitialState() = LoginState(
        loading = false,
        username = "",
        password = ""
    )
}
