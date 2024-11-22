package ru.plodushcheva.newella.profile.main.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.plodushcheva.newella.profile.main.data.model.ProfileModel
import ru.plodushcheva.newella.profile.main.domain.usecase.GetModeUseCase
import ru.plodushcheva.newella.profile.main.domain.usecase.SaveModeUseCase
import kotlin.coroutines.cancellation.CancellationException

class ProfileViewModel(
    private val router: ProfileRouter,
    private val getModeUseCase: GetModeUseCase,
    private val saveModeUseCase: SaveModeUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<ProfileState>(ProfileState.Initial)
    val state: StateFlow<ProfileState> = _state

    fun loadMode() {
        if (_state.value is ProfileState.Content || _state.value is ProfileState.Loading) {
            return
        }

        viewModelScope.launch {
            _state.value = ProfileState.Loading

            try {
                val mode = getModeUseCase()
                _state.value = ProfileState.Content(ProfileModel(mode))
            } catch (ce: CancellationException) {
                throw ce
            } catch (ex: Exception) {
                _state.value = ProfileState.Failure(ex.message)
            }
        }
    }

    fun toggleMode() {
        viewModelScope.launch {
            val currentMode = (_state.value as? ProfileState.Content)?.profile?.mode ?: true
            val newMode = !currentMode
            saveModeUseCase(newMode)
            _state.value = ProfileState.Content(ProfileModel(newMode))
        }
    }

    fun openAuth() {
        router.openAuth()
    }

    fun openAbout() {
        router.openAbout()
    }

    fun openRatings() {
        router.openRatings()
    }

    fun openHistory() {
        router.openHistory()
    }

    fun openSettings() {
        router.openSettings()
    }

}