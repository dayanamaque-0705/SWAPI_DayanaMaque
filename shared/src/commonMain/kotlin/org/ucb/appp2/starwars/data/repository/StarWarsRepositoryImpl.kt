package org.ucb.appp2.starwars.data.repository

import org.ucb.appp2.starwars.data.datasource.StarWarsRemoteDataSource
import org.ucb.appp2.starwars.domain.model.StarWarsCharacterModel
import org.ucb.appp2.starwars.domain.repository.StarWarsRepository

class StarWarsRepositoryImpl(
    private val datasource: StarWarsRemoteDataSource
) : StarWarsRepository {
    override suspend fun getCharacter(id: Int): Result<StarWarsCharacterModel> {
        return datasource.getCharacter(id)
    }
}