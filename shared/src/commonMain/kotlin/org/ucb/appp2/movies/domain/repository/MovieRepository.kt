package org.ucb.appp2.movies.domain.repository

import org.ucb.appp2.movies.domain.model.MovieModel

interface MovieRepository {
    suspend fun getMovies(): List<MovieModel>
}