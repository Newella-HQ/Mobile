package ru.plodushcheva.newella.main.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf
import ru.plodushcheva.newella.R
import ru.plodushcheva.newella.home.HomeRoute
import ru.plodushcheva.newella.home.ui.HomeScreen
import ru.plodushcheva.newella.main.presentation.MainViewModel
import ru.plodushcheva.newella.main.presentation.NavigationOption
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

            BottomNavigation(
                navigationOptions = state.navigationOptions,
                selectedNavigationOption = state.selectedNavOption,
                onItemClicked = mainViewModel::openOption,
            )
        }
    }

}

@Composable
private fun BottomNavigation(
    navigationOptions: List<NavigationOption>,
    selectedNavigationOption: NavigationOption?,
    onItemClicked: (NavigationOption) -> Unit,
) {
    NavigationBar {
        for (option in navigationOptions) {
            NavigationBarItem(
                selected = selectedNavigationOption == option,
                onClick = { onItemClicked(option) },
                icon = { Icon(navOptionIcon(option), "") },
                label = { Text(text = navOptionLabel(option)) }
            )
        }
    }
}

private fun navOptionIcon(option: NavigationOption): ImageVector =
    when (option) {
        NavigationOption.HOME    -> Icons.Default.Home
    }

@Composable
private fun navOptionLabel(option: NavigationOption): String = stringResource(
    when (option) {
        NavigationOption.HOME    -> R.string.bottom_bar_home
    }
)