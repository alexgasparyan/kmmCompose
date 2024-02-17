package com.kmm.compose.di

import com.kmm.compose.data.network.AuthInterceptor
import com.kmm.compose.data.network.HttpClientProvider
import com.kmm.compose.data.repo.AuthRepository
import com.kmm.compose.data.repo.AuthRepositoryImpl
import com.kmm.compose.data.source.AuthRemoteSource
import com.kmm.compose.data.source.KeyValueSource
import com.russhwolf.settings.Settings
import de.jensklingenberg.ktorfit.Ktorfit
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val dataModule = module {

    single<Ktorfit> {
        val authInterceptor = lazy {
            AuthInterceptor(
                authRemoteSource = get(),
                keyValueSource = get()
            )
        }
        val httpClient = HttpClientProvider(authInterceptor = authInterceptor)
        Ktorfit.Builder()
            .httpClient(httpClient())
            .baseUrl("https://swapi.dev/api/")
            .build()
    }

    single<AuthRemoteSource> { get<Ktorfit>().create() }

    single<KeyValueSource> { Settings() }

    singleOf(::AuthRepositoryImpl) { bind<AuthRepository>() }
}
