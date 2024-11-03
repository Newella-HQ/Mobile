package ru.plodushcheva.newella.navigation.feathurerouter

import ru.plodushcheva.newella.center.creating.CreatingRoute
import ru.plodushcheva.newella.center.reading.ReadingRoute
import ru.plodushcheva.newella.home.HomeRoute
import ru.plodushcheva.newella.library.LibraryRoute
import ru.plodushcheva.newella.main.presentation.MainRouter
import ru.plodushcheva.newella.navigation.GlobalRouter
import ru.plodushcheva.newella.profile.ProfileRoute
import ru.plodushcheva.newella.profile.auth.AuthRoute
import ru.plodushcheva.newella.search.SearchRoute

class MainRouterImpl(private val globalRouter: GlobalRouter) : MainRouter {

    override fun openHome() {
        globalRouter.openPoppingAllPrevious(HomeRoute)
    }

    override fun openSearch() {
        globalRouter.openPoppingAllPrevious(SearchRoute)
    }

    override fun openLibrary() {
        globalRouter.openPoppingAllPrevious(LibraryRoute)
    }

    override fun openProfile() {
        globalRouter.openPoppingAllPrevious(ProfileRoute)
    }

    override fun openCreating() {
        globalRouter.openPoppingAllPrevious(CreatingRoute)
    }

    override fun openReading() {
        globalRouter.openPoppingAllPrevious(ReadingRoute)
    }

    override fun openAuth() {
        globalRouter.openPoppingAllPrevious(AuthRoute)
    }

}