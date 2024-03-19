package br.com.fiap.smarthealthmap.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun DetailsScreen(
    navController : NavController
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Welcome to DetailsScreen")
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    val navController = rememberNavController()
    DetailsScreen(navController)
}