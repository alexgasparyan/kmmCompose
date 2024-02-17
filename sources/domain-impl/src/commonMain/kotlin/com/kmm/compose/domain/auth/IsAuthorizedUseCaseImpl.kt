package com.kmm.compose.domain.auth

import com.kmm.compose.data.repo.AuthRepository

class IsAuthorizedUseCaseImpl(
    private val authRepository: AuthRepository
) : IsAuthorizedUseCase {

    override fun invoke() = authRepository.isAuthorized()
}