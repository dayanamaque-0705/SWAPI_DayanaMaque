package org.ucb.appp2.movies.domain.model

import org.ucb.appp2.movies.domain.vo.PosterPath

data class MovieModel(
    val title: String,
    val description: String,
    val posterPath: PosterPath
)
