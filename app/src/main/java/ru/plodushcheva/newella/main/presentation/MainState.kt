package ru.plodushcheva.newella.main.presentation

data class MainState(
    val navigationOptions: List<NavigationOption>,
    val selectedNavOption: NavigationOption?,
    val mode: Boolean = true
)