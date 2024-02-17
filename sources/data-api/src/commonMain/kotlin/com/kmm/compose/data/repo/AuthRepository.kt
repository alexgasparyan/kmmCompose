package com.kmm.compose.data.repo

interface AuthRepository {

    fun isAuthorized(): Boolean

    suspend fun auth(username: String, password: String)
}
