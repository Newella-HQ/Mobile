package ru.plodushcheva.newella.navigation.feathurerouter

import ru.plodushcheva.newella.navigation.GlobalRouter
import ru.plodushcheva.newella.profile.auth.AuthRoute
import ru.plodushcheva.newella.profile.presentation.ProfileRouter

class ProfileRouterImpl(private val globalRouter: GlobalRouter) : ProfileRouter {

    override fun openAuth() {
        globalRouter.open(AuthRoute)
    }

}