package ru.plodushcheva.newella.navigation.feathurerouter

import ru.plodushcheva.newella.home.HomeRoute
import ru.plodushcheva.newella.main.presentation.MainRouter
import ru.plodushcheva.newella.navigation.GlobalRouter
import ru.plodushcheva.newella.search.SearchRoute

class MainRouterImpl(private val globalRouter: GlobalRouter) : MainRouter {

    override fun openHome() {
        globalRouter.openPoppingAllPrevious(HomeRoute)
    }

    override fun openSearch() {
        globalRouter.openPoppingAllPrevious(SearchRoute)
    }

}