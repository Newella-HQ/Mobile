package ru.plodushcheva.newella.navigation.feathurerouter

import ru.plodushcheva.newella.common.novel.NovelRoute
import ru.plodushcheva.newella.home.presentation.HomeRouter
import ru.plodushcheva.newella.navigation.GlobalRouter

class HomeRouterImpl(private val globalRouter: GlobalRouter) : HomeRouter {

	override fun openNovel(novelId: Int) {
		globalRouter.open(NovelRoute(novelId))
	}

}