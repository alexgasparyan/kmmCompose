package com.kmm.compose.util

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.LocalFocusManager

fun Modifier.hideKeyboardOnClick(): Modifier = composed {
    var hideKeyboard by remember { mutableStateOf(false) }
    if (hideKeyboard) {
        LocalFocusManager.current.clearFocus()
        hideKeyboard = false
    }
    clickable(
        interactionSource = remember { MutableInteractionSource() },
        indication = null
    ) {
        hideKeyboard = true
    }
}
