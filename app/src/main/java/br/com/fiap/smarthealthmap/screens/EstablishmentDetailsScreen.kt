package br.com.fiap.smarthealthmap.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.smarthealthmap.service.EstablishmentStateHolder

@Composable
fun DetailsScreen(
    navController : NavController
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = EstablishmentStateHolder.establishment.nome)
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    val navController = rememberNavController()
    DetailsScreen(navController)
}