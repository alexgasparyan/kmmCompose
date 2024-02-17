package com.kmm.compose.presentation.base

data class FlowState(
    val child: Screen<*, *, *>?
)

sealed interface FlowIntent {

    data object Init : FlowIntent
}
