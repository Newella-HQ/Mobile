package ru.plodushcheva.newella.main.presentation

import ru.plodushcheva.newella.center.creating.CreatingRoute
import ru.plodushcheva.newella.center.reading.ReadingRoute
import ru.plodushcheva.newella.home.HomeRoute
import ru.plodushcheva.newella.search.SearchRoute
import ru.plodushcheva.newella.library.LibraryRoute
import ru.plodushcheva.newella.profile.main.ProfileRoute


import kotlin.reflect.KClass

enum class NavigationOption(val route: KClass<*>) {
    HOME(HomeRoute::class),
    SEARCH(SearchRoute::class),
    CREATING(CreatingRoute::class),
    READING(ReadingRoute::class),
    LIBRARY(LibraryRoute::class),
    PROFILE(ProfileRoute::class),

}