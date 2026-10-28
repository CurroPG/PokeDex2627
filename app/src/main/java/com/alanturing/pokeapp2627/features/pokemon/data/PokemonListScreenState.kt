package com.alanturing.pokeapp2627.features.pokemon.data

import com.alanturing.pokeapp2627.features.pokemon.data.model.Pokemon

data class PokemonListScreenState(
    val pokemonList: List<Pokemon> = emptyList(),
    val isLoading: Boolean = false
) {}