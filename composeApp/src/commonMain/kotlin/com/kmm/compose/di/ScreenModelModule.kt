package com.kmm.compose.di

import com.kmm.compose.presentation.RootFlowInitIntentHandler
import com.kmm.compose.presentation.RootFlowModel
import com.kmm.compose.presentation.auth.AuthFlowInitIntentHandler
import com.kmm.compose.presentation.auth.AuthFlowModel
import com.kmm.compose.presentation.auth.login.LoginScreenModel
import com.kmm.compose.presentation.auth.login.handler.LoginOnLoginTapIntentHandler
import com.kmm.compose.presentation.auth.login.handler.LoginOnPasswordChangeIntentHandler
import com.kmm.compose.presentation.auth.login.handler.LoginOnUsernameChangeIntentHandler
import com.kmm.compose.presentation.main.MainFlowInitIntentHandler
import com.kmm.compose.presentation.main.MainFlowModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal val screenModelModule = module {

    factoryOf(::RootFlowInitIntentHandler)
    factoryOf(::RootFlowModel)

    factoryOf(::AuthFlowInitIntentHandler)
    factoryOf(::AuthFlowModel)

    factoryOf(::LoginOnUsernameChangeIntentHandler)
    factoryOf(::LoginOnPasswordChangeIntentHandler)
    factoryOf(::LoginOnLoginTapIntentHandler)
    factoryOf(::LoginOnLoginTapIntentHandler)
    factoryOf(::LoginScreenModel)

    factoryOf(::MainFlowInitIntentHandler)
    factoryOf(::MainFlowModel)
}
