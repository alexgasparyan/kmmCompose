package com.kmm.compose.data.network

import com.kmm.compose.entity.error.ClientRemoteException
import com.kmm.compose.entity.error.ServerRemoteException
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException

internal object ResponseValidator {

    suspend operator fun invoke(cause: Throwable) {
        when (cause) {
            is ClientRequestException -> {
                val error: Response.Error = cause.response.body()
                throw ClientRemoteException(
                    code = error.code,
                    message = error.message
                )
            }

            is ServerResponseException -> {
                val error: Response.Error = cause.response.body()
                throw ServerRemoteException(
                    code = error.code,
                    message = error.message
                )
            }
        }
    }
}
