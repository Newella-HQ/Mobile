package ru.plodushcheva.newella.main.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.plodushcheva.newella.main.domain.usecase.GetModeUseCase

class MainViewModel(
    private val router: MainRouter,
    private val getModeUseCase: GetModeUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(MainState(
        NavigationOption.entries,
        NavigationOption.HOME,
        mode = true
    ))
    val state: StateFlow<MainState> = _state

    fun openOption(option: NavigationOption) {
        _state.value = _state.value.copy(selectedNavOption = option)
        when (option) {
            NavigationOption.HOME    -> router.openHome()
            NavigationOption.SEARCH    -> router.openSearch()
            NavigationOption.LIBRARY    -> router.openLibrary()
            NavigationOption.PROFILE    -> router.openProfile()
            NavigationOption.CREATING    -> router.openCreating()
            NavigationOption.READING    -> router.openReading()

        }
    }

    fun handleOpenedScreen(option: NavigationOption?) {
        _state.value = _state.value.copy(selectedNavOption = option)
    }

    fun loadMode() {
        viewModelScope.launch {
            val mode = getModeUseCase()
            _state.value = _state.value.copy(
                mode = mode,
                navigationOptions = updateNavigationOptions(mode)
            )
        }
    }


    private fun updateNavigationOptions(mode: Boolean): List<NavigationOption> {
        val centerOption = if (mode) NavigationOption.CREATING else NavigationOption.READING

        return listOf(
            NavigationOption.HOME,
            NavigationOption.SEARCH,
            centerOption,
            NavigationOption.LIBRARY,
            NavigationOption.PROFILE
        )
    }

}