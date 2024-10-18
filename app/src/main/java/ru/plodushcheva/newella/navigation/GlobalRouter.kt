package ru.plodushcheva.newella.navigation

interface GlobalRouter {

    fun open(route: Any)

    fun openPoppingAllPrevious(route: Any)

    fun pop()
}