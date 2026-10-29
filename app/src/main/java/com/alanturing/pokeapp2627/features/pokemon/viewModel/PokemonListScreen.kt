package com.alanturing.pokeapp2627.features.pokemon.viewModel

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage

@Composable
fun PokemonListScreen(
    viewModel: PokemonViewModel = hiltViewModel()
){
    val state by viewModel.state.collectAsStateWithLifecycle()

    LazyColumn {
        items(
            items = state.pokemonList,
            key = { it.id }
        ) { pokemon ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = pokemon.pokemonImageUrl,
                    contentDescription = pokemon.name
                )
                Text(text = pokemon.name)
            }

        }
    }
}