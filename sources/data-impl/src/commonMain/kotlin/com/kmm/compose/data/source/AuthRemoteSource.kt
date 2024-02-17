package com.kmm.compose.data.source

import com.kmm.compose.data.entity.AuthRequest
import com.kmm.compose.data.entity.AuthResult
import de.jensklingenberg.ktorfit.http.POST
import de.jensklingenberg.ktorfit.http.Body

interface AuthRemoteSource {

    @POST("auth")
    suspend fun auth(@Body request: AuthRequest): AuthResult

    @POST("auth")
    suspend fun refreshToken(@Body refreshToken: String): AuthResult
}
