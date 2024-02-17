package com.kmm.compose.presentation.base

import cafe.adriel.voyager.core.model.screenModelScope
import io.github.aakira.napier.LogLevel
import io.github.aakira.napier.log
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class IntentHandler<Intent : Any, ScreenModel : com.kmm.compose.presentation.base.ScreenModel<*, in Intent>>(
    private val cancelPrevious: Boolean = false
) {

    private var activeJob: Job? = null

    fun onIntent(screenModel: ScreenModel, intent: Intent) {
        if (cancelPrevious) {
            activeJob?.cancel()
        }
        activeJob = screenModel.screenModelScope.launch {
            try {
                screenModel.onIntentInternal(intent)
            } catch (cancellationException: CancellationException) {
                // silently ignore
            } catch (exception: Exception) {
                log(throwable = exception, tag = "IntentHandlerError") {
                    "${screenModel::class.simpleName}.onIntent($intent) failed."
                }
                screenModel.onError(intent, exception)
            }
        }
    }

    protected abstract suspend fun ScreenModel.onIntentInternal(intent: Intent)

    protected abstract suspend fun ScreenModel.onError(intent: Intent, exception: Exception)
}
