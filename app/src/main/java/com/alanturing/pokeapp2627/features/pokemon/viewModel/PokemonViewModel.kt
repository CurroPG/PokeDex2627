package com.alanturing.pokeapp2627.features.pokemon.viewModel

import androidx.lifecycle.ViewModel
import com.alanturing.pokeapp2627.features.pokemon.data.PokemonListScreenState
import com.alanturing.pokeapp2627.features.pokemon.data.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(repository: PokemonRepository): ViewModel(){

    private val _state = MutableStateFlow(PokemonListScreenState())
    val state: StateFlow<PokemonListScreenState>
        get() = _state.asStateFlow()

}