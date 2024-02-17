package com.kmm.compose

import kotlin.experimental.ExperimentalNativeApi

@OptIn(ExperimentalNativeApi::class)
actual object BuildParams {

    actual val isDebug: Boolean
        get() = Platform.isDebugBinary
}
