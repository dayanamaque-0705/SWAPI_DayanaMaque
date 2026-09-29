package org.ucb.appp2.starwars.domain.repository
import org.ucb.appp2.starwars.domain.model.StarWarsCharacterModel

interface StarWarsRepository {
    suspend fun getCharacter(id: Int): Result<StarWarsCharacterModel>
}