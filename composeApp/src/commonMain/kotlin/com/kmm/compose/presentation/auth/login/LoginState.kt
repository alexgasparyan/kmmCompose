package com.kmm.compose.presentation.auth.login

data class LoginState(
    val loading: Boolean,
    val username: String,
    val password: String
)

sealed interface LoginIntent {
    class OnUsernameChange(val text: String) : LoginIntent
    class OnPasswordChange(val text: String) : LoginIntent
    data object OnLoginTap: LoginIntent
}
