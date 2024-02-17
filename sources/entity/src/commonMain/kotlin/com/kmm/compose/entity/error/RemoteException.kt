package com.kmm.compose.entity.error

abstract class RemoteException(
    val code: Int?,
    message: String
) : Exception(message)

class ClientRemoteException(
    code: Int?,
    message: String
) : RemoteException(
    code = code,
    message = message
)

class ServerRemoteException(
    code: Int?,
    message: String
) : RemoteException(
    code = code,
    message = message
)
