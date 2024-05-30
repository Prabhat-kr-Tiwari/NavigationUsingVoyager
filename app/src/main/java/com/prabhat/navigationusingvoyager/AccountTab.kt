package com.prabhat.navigationusingvoyager

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import cafe.adriel.voyager.transitions.FadeTransition
import cafe.adriel.voyager.transitions.SlideTransition

object AccountTab:Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title="Account"
            val icon= rememberVectorPainter(image = Icons.Rounded.AccountCircle)
            return remember {
                TabOptions(index = 1u, title = title, icon = icon)
            }
        }

    @Composable
    override fun Content() {
        Navigator(screen = Screen1()){navigator->
            FadeTransition(navigator = navigator)
        }
    }
}