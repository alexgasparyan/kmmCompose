package com.kmm.compose.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class AuthResult(
    @SerialName("token")
    val token: String,
    @SerialName("refreshToken")
    val refreshToken: String
)
