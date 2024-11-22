package ru.plodushcheva.newella.navigation.feathurerouter

import ru.plodushcheva.newella.navigation.GlobalRouter
import ru.plodushcheva.newella.profile.auth.AuthRoute
import ru.plodushcheva.newella.profile.about.AboutRoute
import ru.plodushcheva.newella.profile.ratings.RatingsRoute
import ru.plodushcheva.newella.profile.history.HistoryRoute
import ru.plodushcheva.newella.profile.settings.SettingsRoute
import ru.plodushcheva.newella.profile.main.presentation.ProfileRouter

class ProfileRouterImpl(private val globalRouter: GlobalRouter) : ProfileRouter {

    override fun openAuth() {
        globalRouter.open(AuthRoute)
    }

    override fun openAbout() {
        globalRouter.open(AboutRoute)
    }

    override fun openRatings() {
        globalRouter.open(RatingsRoute)
    }

    override fun openHistory() {
        globalRouter.open(HistoryRoute)
    }

    override fun openSettings() {
        globalRouter.open(SettingsRoute)
    }

}