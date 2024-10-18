package ru.plodushcheva.newella.main.presentation

import ru.plodushcheva.newella.home.HomeRoute
import kotlin.reflect.KClass

enum class NavigationOption(val route: KClass<*>) {
    HOME(HomeRoute::class)
}