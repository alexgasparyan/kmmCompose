package com.kmm.compose.data.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class HttpClientProvider(
    private val authInterceptor: Lazy<AuthInterceptor>
) {

    operator fun invoke() = HttpClient {
        followRedirects = true
        expectSuccess = true
        defaultRequest {
            contentType(ContentType.Application.Json)
        }
        install(ContentNegotiation) {
            json(
                json = Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                }
            )
        }
        install(Auth) {
            bearer {
                loadTokens { authInterceptor.value.getLocalTokens() }
                refreshTokens { authInterceptor.value.refreshAndGetLocalTokens() }
            }
        }
        HttpResponseValidator {
            handleResponseExceptionWithRequest { cause, _ -> ResponseValidator(cause) }
        }
    }
}
