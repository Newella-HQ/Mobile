package ru.plodushcheva.newella.main.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf
import ru.plodushcheva.newella.home.HomeRoute
import ru.plodushcheva.newella.home.ui.HomeScreen
import ru.plodushcheva.newella.main.presentation.MainViewModel
import ru.plodushcheva.newella.navigation.NavControllerHolder

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val globalRouterImpl = koinInject<NavControllerHolder>()
    val mainViewModel = koinViewModel<MainViewModel>()

    val state by mainViewModel.state.collectAsStateWithLifecycle()

    DisposableEffect(key1 = Unit) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            val openedOption = state.navigationOptions.firstOrNull {
                destination.hasRoute(route = it.route)
            }
            mainViewModel.handleOpenedScreen(openedOption)
        }

        globalRouterImpl.setNavController(navController)
        onDispose {
            globalRouterImpl.clearNavController()
        }
    }

    Surface {
        Column {
            NavHost(
                modifier = Modifier.weight(1f),
                navController = navController,
                startDestination = HomeRoute,
            ) {
                composable<HomeRoute> {
                    HomeScreen(
                        homeViewModel = koinViewModel(),
                    )
                }
            }
        }
    }



}