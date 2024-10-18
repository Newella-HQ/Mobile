package ru.plodushcheva.newella.main.presentation

import ru.plodushcheva.newella.home.HomeRoute
import ru.plodushcheva.newella.search.SearchRoute

import kotlin.reflect.KClass

enum class NavigationOption(val route: KClass<*>) {
    HOME(HomeRoute::class),
    SEARCH(SearchRoute::class)
}