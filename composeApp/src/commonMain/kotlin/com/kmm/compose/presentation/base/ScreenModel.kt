package com.kmm.compose.presentation.base

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlin.reflect.KClass

abstract class ScreenModel<State : Any, Intent : Any> : ScreenModel {

    private val _state = MutableStateFlow(getInitialStateInternal())
    val state: StateFlow<State> = _state

    private val _navigation = Channel<NavigationCommand?>()
    val navigation: Flow<NavigationCommand?> = _navigation.receiveAsFlow()

    protected val intentHandlers: Map<KClass<out Intent>, IntentHandler<out Intent, out com.kmm.compose.presentation.base.ScreenModel<*, Intent>>> = mutableMapOf()

    protected inline fun <reified I : Intent, IH : IntentHandler<I, out com.kmm.compose.presentation.base.ScreenModel<*, Intent>>> registerIntentHandler(intentHandler: IH) {
        // Since method is inline, intentHandlers needs to be exposed to children (should be at least protected).
        // Since we do not want to expose mutable value to children, casting is the only option.
        (intentHandlers as MutableMap)[I::class] = intentHandler
    }

    @Suppress("Unchecked_Cast")
    fun onIntent(intent: Intent) {
        val intentHandler = intentHandlers[intent::class] as? IntentHandler<Intent, com.kmm.compose.presentation.base.ScreenModel<*, Intent, >>
            ?: throw IllegalStateException("Intent handler not registered for intent class ${intent::class.simpleName}")
        intentHandler.onIntent(this, intent)
    }

    private fun getInitialStateInternal(): State {
        return getInitialState()
    }

    protected abstract fun getInitialState(): State

    internal fun setState(reducer: State.() -> State) {
        _state.value = reducer(state.value)
    }

    internal open fun navigate(command: NavigationCommand) = screenModelScope.launch {
        _navigation.send(command)
    }
}
