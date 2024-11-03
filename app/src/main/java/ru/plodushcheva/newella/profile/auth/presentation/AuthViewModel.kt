package ru.plodushcheva.newella.profile.auth.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AuthViewModel(
    private val router: AuthRouter
) : ViewModel() {

    enum class AuthMode { LOGIN, REGISTER }

    private val _authMode = MutableStateFlow(AuthMode.LOGIN)
    val authMode: StateFlow<AuthMode> = _authMode

    fun setAuthMode(mode: AuthMode) {
        _authMode.value = mode
    }

    fun getAuthMode(): AuthMode {
        return _authMode.value
    }

}