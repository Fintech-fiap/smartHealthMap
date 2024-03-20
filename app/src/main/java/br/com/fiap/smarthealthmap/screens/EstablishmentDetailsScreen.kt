package br.com.fiap.smarthealthmap.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.smarthealthmap.R
import br.com.fiap.smarthealthmap.model.Establishment
import br.com.fiap.smarthealthmap.service.EstablishmentStateHolder


// Tela de detalhes do estabelecimento
@Composable
fun DetailsScreen(
    navController: NavController
) {
    Spacer(modifier = Modifier.height(10.dp))
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { navController.navigate("establishments") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Black
                )
            )
            {
            Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "Retornar à listagem")
            }
            Row(
                modifier = Modifier.padding(4.dp)
            ) {
                Image(
                    modifier = Modifier.size(32.dp, 32.dp),
                    painter = painterResource(id = R.drawable.small_logo),
                    contentDescription = "Logomarca"
                )
                Text(
                    centerLetterWithColor("SHM"),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        // Exibir detalhes do estabelecimento
        Text(text = EstablishmentStateHolder.establishment.nome)
        Text(text = "Endereço: ${EstablishmentStateHolder.establishment.logradouro}, ${EstablishmentStateHolder.establishment.numero}, ${EstablishmentStateHolder.establishment.bairro}, ${EstablishmentStateHolder.establishment.codigoUf} - ${EstablishmentStateHolder.establishment.cep}")
        Text(text = "Email: ${EstablishmentStateHolder.establishment.email}")
        Text(text = "Telefone: ${EstablishmentStateHolder.establishment.telefone}")
        Text(text = "Turnos de Atendimento: ${EstablishmentStateHolder.establishment.turnos}")
    }
}

// Pré-visualização da tela de detalhes (para visualizar o layout durante o desenvolvimento)
@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    val navController = rememberNavController()
    DetailsScreen(navController)
}