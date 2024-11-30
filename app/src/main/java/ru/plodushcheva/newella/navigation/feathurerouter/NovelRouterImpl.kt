package ru.plodushcheva.newella.navigation.feathurerouter

import ru.plodushcheva.newella.common.novel.presentation.NovelRouter
import ru.plodushcheva.newella.navigation.GlobalRouter


class NovelRouterImpl(private val globalRouter: GlobalRouter) : NovelRouter {

	override fun goBack() {
		globalRouter.pop()
	}
}