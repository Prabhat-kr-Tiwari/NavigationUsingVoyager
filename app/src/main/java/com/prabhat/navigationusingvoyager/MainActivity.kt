package com.prabhat.navigationusingvoyager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.prabhat.navigationusingvoyager.ui.theme.NavigationUsingVoyagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationUsingVoyagerTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
//                    Navigator(screen = Screen1())
                    TabNavigator(tab = HomeTab) {
                        Scaffold(modifier = Modifier.height(10.dp),bottomBar = {
                            NavigationBar{

                                TabNavigationItem(tab = HomeTab)
                                TabNavigationItem(tab = AccountTab)
                            }
                        }) {

                            Box(modifier = Modifier.padding(bottom = it.calculateBottomPadding())) {

                                CurrentTab()
                            }

                        }
                    }

                }
            }
        }
    }
}

@Composable
fun RowScope.TabNavigationItem(tab: Tab) {

    val tabNavigator = LocalTabNavigator.current
    NavigationBarItem(
        selected =tabNavigator.current==tab,
        onClick = {
                  tabNavigator.current=tab
        },
        icon = {
            tab.options.icon?.let {
                Icon(
                    painter =it ,
                    contentDescription = tab.options.title
                )
            }
        },
        label = { Text(text = tab.options.title) }

    )
}


