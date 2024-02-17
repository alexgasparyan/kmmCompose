package com.kmm.compose.di

import com.kmm.compose.domain.auth.AuthUseCase
import com.kmm.compose.domain.auth.AuthUseCaseImpl
import com.kmm.compose.domain.auth.IsAuthorizedUseCase
import com.kmm.compose.domain.auth.IsAuthorizedUseCaseImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val domainModule = module {

    singleOf(::IsAuthorizedUseCaseImpl) { bind<IsAuthorizedUseCase>() }

    singleOf(::AuthUseCaseImpl) { bind<AuthUseCase>() }
}
