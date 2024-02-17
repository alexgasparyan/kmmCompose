package com.kmm.compose.presentation.auth.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.koin.getScreenModel
import com.kmm.compose.presentation.base.Screen
import com.kmm.compose.util.hideKeyboardOnClick
import kmmcompose.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource

data object LoginScreen : Screen<LoginState, LoginIntent, LoginScreenModel>() {

    @Composable
    override fun getScreenModel() = getScreenModel<LoginScreenModel>()

    @Composable
    override fun LoginState.Render(screenModel: LoginScreenModel) {
        Render(
            onUsernameChange = { screenModel.onIntent(LoginIntent.OnUsernameChange(it)) },
            onPasswordChange = { screenModel.onIntent(LoginIntent.OnPasswordChange(it)) },
            onLoginButtonTap = { screenModel.onIntent(LoginIntent.OnLoginTap) }
        )
    }

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    internal fun LoginState.Render(
        onUsernameChange: (String) -> Unit,
        onPasswordChange: (String) -> Unit,
        onLoginButtonTap: () -> Unit
    ) {
        Box(
            modifier = Modifier
                .hideKeyboardOnClick()
                .padding(horizontal = 16.dp)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.TopCenter)
            ) {
                TextField(
                    modifier = Modifier
                        .padding(top = 150.dp)
                        .fillMaxWidth(),
                    value = username,
                    label = { Text(text = stringResource(Res.string.auth_login_username)) },
                    onValueChange = onUsernameChange
                )
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    value = password,
                    label = { Text(text = stringResource(Res.string.auth_login_password)) },
                    onValueChange = onPasswordChange
                )
            }
            Button(
                modifier = Modifier
                    .imePadding()
                    .padding(bottom = 24.dp)
                    .fillMaxWidth()
                    .height(56.dp)
                    .align(Alignment.BottomCenter),
                shape = RoundedCornerShape(size = 10.dp),
                onClick = onLoginButtonTap
            ) {
                if (loading) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .padding(vertical = 12.dp)
                            .fillMaxHeight()
                            .aspectRatio(ratio = 1F),
                        color = Color.White,
                        strokeWidth = 2.dp
                    )
                } else {
                    Text(
                        text = stringResource(Res.string.auth_login),
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}
