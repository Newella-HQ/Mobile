package ru.plodushcheva.newella.profile.presentation

import ru.plodushcheva.newella.profile.data.model.ProfileModel

interface ProfileState {

    data object Initial : ProfileState
    data object Loading : ProfileState
    data class Failure(val message: String?) : ProfileState
    data class Content(val profile: ProfileModel) : ProfileState

}