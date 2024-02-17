package com.kmm.compose.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class AuthRequest(
    @SerialName("username")
    val username: String,
    @SerialName("password")
    val password: String
)
