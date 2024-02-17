package com.kmm.compose.data.repo

import com.kmm.compose.data.entity.AuthRequest
import com.kmm.compose.data.source.AuthRemoteSource
import com.kmm.compose.data.source.KeyValueSource
import com.kmm.compose.data.source.KeyValueSourceKey

class AuthRepositoryImpl(
    private val authRemoteSource: AuthRemoteSource,
    private val keyValueSource: KeyValueSource
) : AuthRepository {

    override fun isAuthorized(): Boolean {
        return keyValueSource.hasKey(KeyValueSourceKey.TOKEN)
    }

    override suspend fun auth(username: String, password: String) {
        val authRequest = AuthRequest(
            username = username,
            password = password
        )
        authRemoteSource.auth(authRequest).let {
            keyValueSource.putString(key = KeyValueSourceKey.TOKEN, value = it.token)
            keyValueSource.putString(key = KeyValueSourceKey.REFRESH_TOKEN, value = it.refreshToken)
        }
    }
}
