package org.ucb.appp2.starwars.presentation.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.ucb.appp2.starwars.domain.usecase.GetStarWarsCharacterUseCase

class CharacterViewModel(
    private val getStarWarsCharacterUseCase: GetStarWarsCharacterUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<CharacterUiState>(CharacterUiState.Loading)
    val uiState: StateFlow<CharacterUiState> = _uiState.asStateFlow()

    init {
        loadCharacter(id = 1)
    }

    fun loadCharacter(id: Int) {
        viewModelScope.launch {
            _uiState.value = CharacterUiState.Loading
            val result = getStarWarsCharacterUseCase(id)
            result.onSuccess { character ->
                _uiState.value = CharacterUiState.Success(character)
            }.onFailure { error ->
                _uiState.value = CharacterUiState.Error(error.message ?: "Error de red")
            }
        }
    }
}