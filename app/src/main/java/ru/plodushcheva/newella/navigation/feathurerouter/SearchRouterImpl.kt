package ru.plodushcheva.newella.navigation.feathurerouter

import ru.plodushcheva.newella.common.novel.NovelRoute
import ru.plodushcheva.newella.navigation.GlobalRouter
import ru.plodushcheva.newella.search.presentation.SearchRouter

class SearchRouterImpl(private val globalRouter: GlobalRouter) : SearchRouter {

	override fun openNovel(novelId: Int) {
		globalRouter.open(NovelRoute(novelId))
	}

}