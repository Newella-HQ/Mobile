package ru.plodushcheva.newella.main.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel(
    private val router: MainRouter,
) : ViewModel() {

    private val _state = MutableStateFlow(MainState(
        NavigationOption.entries,
        NavigationOption.HOME,
    ))
    val state: StateFlow<MainState> = _state

    fun openOption(option: NavigationOption) {
        _state.value = _state.value.copy(selectedNavOption = option)
        when (option) {
            NavigationOption.HOME    -> router.openHome()
        }
    }

    fun handleOpenedScreen(option: NavigationOption?) {
        _state.value = _state.value.copy(selectedNavOption = option)
    }
}