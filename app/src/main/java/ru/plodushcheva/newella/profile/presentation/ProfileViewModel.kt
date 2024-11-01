package ru.plodushcheva.newella.profile.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.plodushcheva.newella.profile.data.model.ProfileModel
import ru.plodushcheva.newella.profile.domain.usecase.GetModeUseCase
import kotlin.coroutines.cancellation.CancellationException

class ProfileViewModel(
    private val router: ProfileRouter,
    private val getModeUseCase: GetModeUseCase
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

}