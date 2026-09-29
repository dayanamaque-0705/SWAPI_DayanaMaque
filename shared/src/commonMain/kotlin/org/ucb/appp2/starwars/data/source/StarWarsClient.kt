package org.ucb.appp2.starwars.data.source

import org.ucb.appp2.starwars.data.model.StarWarsCharacterDto
import org.ucb.appp2.starwars.domain.model.StarWarsCharacterModel
import org.ucb.appp2.starwars.data.mapper.toModel
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class StarWarsClient {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json { prettyPrint = true; ignoreUnknownKeys = true })
        }
    }

    suspend fun fetchCharacter(id: Int): Result<StarWarsCharacterModel> {
        return try {
            val response = client.get("https://swapi.dev/api/people/$id/")
            val body = response.body<StarWarsCharacterDto>()
            Result.success(body.toModel())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}