package ru.plodushcheva.newella.main.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
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
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject
import ru.plodushcheva.newella.R
import ru.plodushcheva.newella.center.creating.CreatingRoute
import ru.plodushcheva.newella.center.creating.ui.CreatingScreen
import ru.plodushcheva.newella.center.reading.ReadingRoute
import ru.plodushcheva.newella.center.reading.ui.ReadingScreen
import ru.plodushcheva.newella.home.HomeRoute
import ru.plodushcheva.newella.home.ui.HomeScreen
import ru.plodushcheva.newella.library.LibraryRoute
import ru.plodushcheva.newella.library.ui.LibraryScreen
import ru.plodushcheva.newella.main.presentation.MainViewModel
import ru.plodushcheva.newella.main.presentation.NavigationOption
import ru.plodushcheva.newella.navigation.NavControllerHolder
import ru.plodushcheva.newella.profile.ProfileRoute
import ru.plodushcheva.newella.profile.ui.ProfileScreen
import ru.plodushcheva.newella.search.SearchRoute
import ru.plodushcheva.newella.search.ui.SearchScreen

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

                composable<SearchRoute> {
                    SearchScreen(
                        searchViewModel = koinViewModel(),
                    )
                }

                composable<LibraryRoute> {
                    LibraryScreen(
                        libraryViewModel = koinViewModel(),
                    )
                }

                composable<ProfileRoute> {
                    ProfileScreen(
                        profileViewModel = koinViewModel(),
                    )
                }

                composable<CreatingRoute> {
                    CreatingScreen(
                        creatingViewModel = koinViewModel(),
                    )
                }

                composable<ReadingRoute> {
                    ReadingScreen(
                        readingViewModel = koinViewModel(),
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
        NavigationOption.HOME -> Icons.Default.Home
        NavigationOption.SEARCH -> Icons.Default.Search
        NavigationOption.CREATING -> Icons.Default.Create
        NavigationOption.READING -> Icons.Default.PlayArrow
        NavigationOption.LIBRARY -> Icons.Default.FavoriteBorder
        NavigationOption.PROFILE -> Icons.Default.AccountCircle
    }

@Composable
private fun navOptionLabel(option: NavigationOption): String = stringResource(
    when (option) {
        NavigationOption.HOME -> R.string.bottom_bar_home
        NavigationOption.SEARCH -> R.string.bottom_bar_search
        NavigationOption.CREATING -> R.string.bottom_bar_creating
        NavigationOption.READING -> R.string.bottom_bar_reading
        NavigationOption.LIBRARY -> R.string.bottom_bar_library
        NavigationOption.PROFILE -> R.string.bottom_bar_profile
    }
)