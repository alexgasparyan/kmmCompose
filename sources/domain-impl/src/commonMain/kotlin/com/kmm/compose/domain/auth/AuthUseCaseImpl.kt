package com.kmm.compose.domain.auth

import com.kmm.compose.data.repo.AuthRepository

class AuthUseCaseImpl(
    private val authRepository: AuthRepository
) : AuthUseCase {

    override suspend operator fun invoke(username: String, password: String) {
        authRepository.auth(username = username, password = password)
    }
}
