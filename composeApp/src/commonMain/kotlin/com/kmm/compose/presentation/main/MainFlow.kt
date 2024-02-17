package com.kmm.compose.presentation.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.Navigator
import com.kmm.compose.presentation.base.Flow
import com.kmm.compose.presentation.base.FlowModel
import com.kmm.compose.presentation.base.FlowState

data object MainFlow : Flow() {

    @Composable
    override fun getScreenModel() = getScreenModel<MainFlowModel>()

    @Composable
    override fun FlowState.Render(screenModel: FlowModel) {
        Scaffold {
            Box(modifier = Modifier.padding(it)) {
                child?.let { child ->
                    Navigator(child)
                }
            }
        }
    }
}
