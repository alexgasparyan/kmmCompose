package com.kmm.compose.domain.auth

interface IsAuthorizedUseCase {

    operator fun invoke(): Boolean
}
