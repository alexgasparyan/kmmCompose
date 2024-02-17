package com.kmm.compose.di

import org.koin.core.context.startKoin

internal object DependencyInjection {

    fun init() = startKoin {
        modules(
            dataModule,
            domainModule,
            screenModelModule
        )
    }
}
