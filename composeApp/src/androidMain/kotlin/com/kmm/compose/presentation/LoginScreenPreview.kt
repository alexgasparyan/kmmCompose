package com.kmm.compose.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.kmm.compose.presentation.auth.login.LoginScreen.Render
import com.kmm.compose.presentation.auth.login.LoginState

@Preview(device = "id:pixel_7")
@Composable
fun LoginScreenPreview() {
    LoginState(
        loading = true,
        username = "username@gmail.com",
        password = "12345678"
    ).Render(
        onUsernameChange = {},
        onPasswordChange = {},
        onLoginButtonTap = {}
    )
}
