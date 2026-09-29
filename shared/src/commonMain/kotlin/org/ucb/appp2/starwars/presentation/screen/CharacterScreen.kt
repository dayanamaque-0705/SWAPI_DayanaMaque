package org.ucb.appp2.starwars.presentation.screen
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.compose.viewmodel.koinViewModel
import org.ucb.appp2.starwars.presentation.viewmodel.CharacterUiState
import org.ucb.appp2.starwars.presentation.viewmodel.CharacterViewModel

@Composable
fun CharacterScreen(viewModel: CharacterViewModel = koinViewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        when (val state = uiState) {
            is CharacterUiState.Loading -> CircularProgressIndicator()
            is CharacterUiState.Error -> Text(text = "Error: ${state.message}", color = MaterialTheme.colorScheme.error)
            is CharacterUiState.Success -> {
                val character = state.character
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(text = "Nombre: ${character.name}", style = MaterialTheme.typography.headlineMedium)
                    Text(text = "Altura: ${character.height} cm")
                    Text(text = "Peso: ${character.mass} kg")
                    Text(text = "Cabello: ${character.hairColor}")
                    Text(text = "Piel: ${character.skinColor}")
                    Text(text = "Ojos: ${character.eyeColor}")
                    Text(text = "Año de Nacimiento: ${character.birthYear}")
                    Text(text = "Género: ${character.gender}")
                }
            }
        }
    }
}