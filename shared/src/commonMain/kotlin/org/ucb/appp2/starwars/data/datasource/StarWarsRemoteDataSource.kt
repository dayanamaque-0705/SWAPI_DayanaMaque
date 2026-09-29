package org.ucb.appp2.starwars.data.datasource

import org.ucb.appp2.starwars.data.source.StarWarsClient
import org.ucb.appp2.starwars.domain.model.StarWarsCharacterModel

class StarWarsRemoteDataSource(private val source: StarWarsClient) {
    suspend fun getCharacter(id: Int): Result<StarWarsCharacterModel> {
        return source.fetchCharacter(id)
    }
}