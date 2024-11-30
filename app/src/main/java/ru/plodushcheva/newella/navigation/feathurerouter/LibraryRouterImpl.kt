package ru.plodushcheva.newella.navigation.feathurerouter

import ru.plodushcheva.newella.common.novel.NovelRoute
import ru.plodushcheva.newella.library.presentation.LibraryRouter
import ru.plodushcheva.newella.navigation.GlobalRouter


class LibraryRouterImpl(private val globalRouter: GlobalRouter) : LibraryRouter {

	override fun openNovel(novelId: Int) {
		globalRouter.open(NovelRoute(novelId))
	}

}