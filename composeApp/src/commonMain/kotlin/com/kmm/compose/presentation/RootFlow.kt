package com.kmm.compose.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.Navigator
import com.kmm.compose.presentation.base.Flow
import com.kmm.compose.presentation.base.FlowModel
import com.kmm.compose.presentation.base.FlowState

data object RootFlow : Flow() {

    @Composable
    override fun getScreenModel() = getScreenModel<RootFlowModel>()

    @Composable
    override fun FlowState.Render(screenModel: FlowModel) {
        Scaffold(contentWindowInsets = ScaffoldDefaults.contentWindowInsets) {
            Box(modifier = Modifier.padding(it)) {
                child?.let { child ->
                    Navigator(child)
                }
            }
        }
    }
}
