package com.bernardo.multiverseradar.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.bernardo.multiverseradar.model.PersonagemEntity
import com.bernardo.multiverseradar.viewmodel.EstadoSync

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaPersonagens(
    personagens: List<PersonagemEntity>,
    estado: EstadoSync,
    onSincronizar: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Multiverse Radar", fontWeight = FontWeight.Bold) },
                actions = {
                    IconButton(onClick = { onSincronizar() }) {
                        Icon(Icons.Filled.Refresh, contentDescription = "Sincronizar")
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding)) {

            when (estado) {
                is EstadoSync.Idle -> {}
                is EstadoSync.Loading -> CircularProgressIndicator(modifier = Modifier.padding(8.dp))
                is EstadoSync.Success -> {}
                is EstadoSync.Error -> Text(estado.mensagem, modifier = Modifier.padding(8.dp))
            }

            LazyColumn {
                items(personagens) { personagem ->
                    Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                        Row(
                            modifier = Modifier.padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            AsyncImage(
                                model = personagem.imagemUrl,
                                contentDescription = personagem.nome,
                                modifier = Modifier.size(80.dp)
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text(personagem.nome, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                                Text(personagem.especie)
                            }
                        }
                    }
                }
            }
        }
    }
}
