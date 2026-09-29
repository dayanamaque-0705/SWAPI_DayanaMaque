package org.ucb.appp2.starwars.presentation.viewmodel

import org.ucb.appp2.starwars.domain.model.StarWarsCharacterModel

sealed interface CharacterUiState {
    object Loading : CharacterUiState
    data class Success(val character: StarWarsCharacterModel) : CharacterUiState
    data class Error(val message: String) : CharacterUiState
}