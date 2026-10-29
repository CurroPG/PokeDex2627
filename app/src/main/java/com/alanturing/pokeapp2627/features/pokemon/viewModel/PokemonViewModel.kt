package com.alanturing.pokeapp2627.features.pokemon.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alanturing.pokeapp2627.features.pokemon.data.PokemonListScreenState
import com.alanturing.pokeapp2627.features.pokemon.data.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val repository: PokemonRepository
): ViewModel(){

    private val _state = MutableStateFlow(PokemonListScreenState())
    val state: StateFlow<PokemonListScreenState>
        get() = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val oldState = state.value
            _state.value = oldState.copy(
                repository.readAllPokemon()
            )
        }
    }
}