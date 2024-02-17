package com.kmm.compose.data.network

import com.kmm.compose.data.source.AuthRemoteSource
import com.kmm.compose.data.source.KeyValueSource
import com.kmm.compose.data.source.KeyValueSourceKey
import com.russhwolf.settings.get
import io.ktor.client.plugins.auth.providers.BearerTokens

class AuthInterceptor(
    private val authRemoteSource: AuthRemoteSource,
    private val keyValueSource: KeyValueSource
) {

    fun getLocalTokens(): BearerTokens? {
        val token = keyValueSource.get<String>(KeyValueSourceKey.TOKEN)
        val refreshToken = keyValueSource.get<String>(KeyValueSourceKey.REFRESH_TOKEN)
        return if (token != null && refreshToken != null) {
            BearerTokens(accessToken = token, refreshToken = refreshToken)
        } else null
    }

    suspend fun refreshAndGetLocalTokens(): BearerTokens {
        val refreshToken = keyValueSource.get<String>(KeyValueSourceKey.REFRESH_TOKEN)
        requireNotNull(refreshToken)
        val authResult = authRemoteSource.refreshToken(refreshToken = refreshToken)
        keyValueSource.putString(key = KeyValueSourceKey.TOKEN, value = authResult.token)
        keyValueSource.putString(key = KeyValueSourceKey.REFRESH_TOKEN, value = authResult.refreshToken)
        return BearerTokens(accessToken = authResult.token, refreshToken = authResult.refreshToken)
    }
}
