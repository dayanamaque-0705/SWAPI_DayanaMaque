package org.ucb.appp2.starwars.domain.usecase
import org.ucb.appp2.starwars.domain.model.StarWarsCharacterModel
import org.ucb.appp2.starwars.domain.repository.StarWarsRepository

class GetStarWarsCharacterUseCase(private val repository: StarWarsRepository) {
    suspend operator fun invoke(id: Int): Result<StarWarsCharacterModel> {
        return repository.getCharacter(id)
    }
}