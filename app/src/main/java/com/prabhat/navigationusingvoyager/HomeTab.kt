package com.prabhat.navigationusingvoyager

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import cafe.adriel.voyager.transitions.SlideTransition

object HomeTab:Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title="Home"
            val icon= rememberVectorPainter(image = Icons.Rounded.Home)
            return remember {
                TabOptions(index = 0u, title = title, icon = icon)
            }
        }

    @Composable
    override fun Content() {
        Navigator(screen = Screen1()){navigator->
            SlideTransition(navigator = navigator)
        }
    }
}