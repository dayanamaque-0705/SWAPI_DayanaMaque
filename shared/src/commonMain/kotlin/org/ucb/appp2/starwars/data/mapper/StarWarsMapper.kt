package org.ucb.appp2.starwars.data.mapper
import org.ucb.appp2.starwars.data.model.StarWarsCharacterDto
import org.ucb.appp2.starwars.domain.model.StarWarsCharacterModel

fun StarWarsCharacterDto.toModel(): StarWarsCharacterModel {
    return StarWarsCharacterModel(
        name = name,
        height = height,
        mass = mass,
        hairColor = hairColor,
        skinColor = skinColor,
        eyeColor = eyeColor,
        gender = gender
    )
}