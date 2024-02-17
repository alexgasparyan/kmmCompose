package com.kmm.compose

actual object BuildParams {

    actual val isDebug: Boolean
        get() = BuildConfig.DEBUG

}