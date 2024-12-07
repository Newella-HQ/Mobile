package ru.plodushcheva.newella.center.reading.domain.entity

data class Page(
	val title: String,
	val speaker: String? = null,
	val text: String,
	val imageResId: Int
)