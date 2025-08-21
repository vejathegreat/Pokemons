package com.velaphi.pokemons.infomodule

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.velaphi.pokemons.network.model.PokemonDetailResponse
import com.velaphi.pokemons.network.model.Stat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoScreen(
    onBackClick: () -> Unit,
    viewModel: InfoViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Pokemon Info") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()
        ) {
            when (val currentState = uiState) {
                is InfoUiState.Loading -> LoadingContent()
                is InfoUiState.Success -> PokemonDetailContent(
                    pokemon = currentState.pokemon,
                    scaffoldPadding = paddingValues
                )
                is InfoUiState.Error -> {
                    if (currentState.isNetworkError) {
                        NetworkErrorContent(
                            message = currentState.message,
                            onRetry = viewModel::refresh
                        )
                    } else {
                        SimpleErrorContent(
                            message = currentState.message,
                            onRetry = viewModel::refresh
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun PokemonDetailContent(
    pokemon: PokemonDetailResponse,
    scaffoldPadding: PaddingValues
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(scaffoldPadding),
        contentPadding = PaddingValues(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item { PokemonHeader(pokemon) }
        item { SectionCard("Stats") { StatsList(pokemon.stats) } }
        item { SectionCard("Types") { TypesList(pokemon.types.map { it.type.name }) } }
        item { SectionCard("Abilities") { AbilitiesList(pokemon.abilities.map { it.ability.name to it.isHidden }) } }
        if (pokemon.forms.isNotEmpty()) {
            item { SectionCard("Forms") { FormsList(pokemon.forms.map { it.name }) } }
        }
    }
}

@Composable
private fun PokemonHeader(pokemon: PokemonDetailResponse) = Card(
    modifier = Modifier.fillMaxWidth(),
    elevation = CardDefaults.cardElevation(4.dp)
) {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = pokemon.sprites.frontDefault
                ?: pokemon.sprites.other?.officialArtwork?.frontDefault,
            contentDescription = "Pokemon ${pokemon.name}",
            modifier = Modifier
                .size(200.dp)
                .padding(bottom = 8.dp)
        )
        Text(
            text = pokemon.name.replaceFirstChar { it.uppercase() },
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "#${pokemon.id.toString().padStart(3, '0')}",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            InfoItem("Height", "${pokemon.height / 10.0}m")
            InfoItem("Weight", "${pokemon.weight / 10.0}kg")
            pokemon.baseExperience?.let { InfoItem("Base Exp", it.toString()) }
        }
    }
}

@Composable
private fun InfoItem(label: String, value: String) = Column(
    horizontalAlignment = Alignment.CenterHorizontally
) {
    Text(
        label,
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
    Text(value, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Medium)
}

@Composable
private fun StatsList(stats: List<Stat>) =
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        stats.forEach { stat ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(stat.stat.name.replaceFirstChar { it.uppercase() }, Modifier.weight(1f))
                Text(stat.baseStat.toString(), fontWeight = FontWeight.Medium)
                LinearProgressIndicator(
                    progress = stat.baseStat / 255f,
                    modifier = Modifier
                        .weight(0.5f)
                        .height(8.dp),
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }

@Composable
private fun TypesList(types: List<String>) =
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        types.forEach { type ->
            AssistChip(onClick = {}, label = { Text(type.replaceFirstChar { it.uppercase() }) })
        }
    }

@Composable
private fun AbilitiesList(abilities: List<Pair<String, Boolean>>) =
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        abilities.forEach { (name, isHidden) ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(name.replaceFirstChar { it.uppercase() }, Modifier.weight(1f))
                if (isHidden) AssistChip(onClick = {}, label = { Text("Hidden") })
            }
        }
    }

@Composable
private fun FormsList(forms: List<String>) =
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        forms.forEach { Text(it.replaceFirstChar { it.uppercase() }) }
    }

@Composable
private fun SectionCard(title: String, content: @Composable ColumnScope.() -> Unit) = Card(
    modifier = Modifier.fillMaxWidth(),
    elevation = CardDefaults.cardElevation(2.dp)
) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(title, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        content()
    }
}
