package com.kmm.compose.domain.auth

interface AuthUseCase {

    suspend operator fun invoke(username: String, password: String)
}
