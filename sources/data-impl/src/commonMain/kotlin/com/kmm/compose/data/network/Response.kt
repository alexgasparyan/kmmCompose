package com.kmm.compose.data.network

import kotlinx.serialization.SerialName

internal interface Response {

    class Error(
        @SerialName("code")
        val code: Int? = null,
        @SerialName("message")
        val message: String
    )
}