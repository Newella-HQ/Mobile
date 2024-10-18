package ru.plodushcheva.newella.navigation

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.binds
import org.koin.dsl.module
import ru.plodushcheva.newella.home.presentation.HomeRouter
import ru.plodushcheva.newella.search.presentation.SearchRouter
import ru.plodushcheva.newella.main.presentation.MainRouter
import ru.plodushcheva.newella.navigation.feathurerouter.MainRouterImpl
import ru.plodushcheva.newella.navigation.feathurerouter.HomeRouterImpl
import ru.plodushcheva.newella.navigation.feathurerouter.SearchRouterImpl



val navigationModule = module {
    singleOf(::GlobalRouterImpl) binds arrayOf(GlobalRouter::class, NavControllerHolder::class)

    singleOf(::MainRouterImpl) bind MainRouter::class
    singleOf(::HomeRouterImpl) bind HomeRouter::class
    singleOf(::SearchRouterImpl) bind SearchRouter::class
}