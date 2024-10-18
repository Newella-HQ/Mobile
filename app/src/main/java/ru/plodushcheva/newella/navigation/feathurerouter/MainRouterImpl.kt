package ru.plodushcheva.newella.navigation.feathurerouter

import ru.plodushcheva.newella.home.HomeRoute
import ru.plodushcheva.newella.main.presentation.MainRouter
import ru.plodushcheva.newella.navigation.GlobalRouter

class MainRouterImpl(private val globalRouter: GlobalRouter) : MainRouter {

    override fun openHome() {
        globalRouter.openPoppingAllPrevious(HomeRoute)
    }

}