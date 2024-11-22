package ru.plodushcheva.newella.library.domain.entity

data class NovelSection(
	val title: String,
	val novels: List<NovelItem>
)