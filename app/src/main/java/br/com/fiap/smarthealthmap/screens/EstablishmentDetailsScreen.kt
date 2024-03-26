package br.com.fiap.smarthealthmap.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.smarthealthmap.R
import br.com.fiap.smarthealthmap.service.EstablishmentStateHolder
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState


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
        //Header
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { navController.navigate("establishments") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Black
                )
            )
            {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Retornar à listagem"
                )
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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp)
        ) {
            Text(
                text = EstablishmentStateHolder.establishment.nome,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier.fillMaxWidth()
        ){
            GoogleMap(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(horizontal = 6.dp),
                cameraPositionState = rememberCameraPositionState {
                    position = CameraPosition.fromLatLngZoom(
                        LatLng(
                            EstablishmentStateHolder.establishment.latitude.toDouble(),
                            EstablishmentStateHolder.establishment.longitude.toDouble()
                        ),
                        10f
                    )
                }
            ) {
                Marker(
                    position = LatLng(
                        EstablishmentStateHolder.establishment.latitude.toDouble(),
                        EstablishmentStateHolder.establishment.longitude.toDouble()
                    ),
                    title = EstablishmentStateHolder.establishment.nome,
                    snippet = "Marcação"
                )
            }
        }
        Column(
            modifier = Modifier.padding(horizontal = 6.dp)
        ) {
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                text = "Endereço: ${EstablishmentStateHolder.establishment.logradouro}," +
                        " ${EstablishmentStateHolder.establishment.numero}, " +
                        "${EstablishmentStateHolder.establishment.bairro}, " +
                        "${EstablishmentStateHolder.establishment.codigoUf} - ${EstablishmentStateHolder.establishment.cep}",
                textAlign = TextAlign.Start,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Telefone: ${EstablishmentStateHolder.establishment.telefone}",
                textAlign = TextAlign.Start,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Turnos de Atendimento: ${EstablishmentStateHolder.establishment.turnos}",
                textAlign = TextAlign.Start,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Faz atendimento ambulatorial do SUS? ${changeValue(EstablishmentStateHolder.establishment.atendimentoAmbulatorialSUS)}",
                textAlign = TextAlign.Start,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Possui centro cirúrgico? ${changeValue(EstablishmentStateHolder.establishment.centroCirurgico)}",
                textAlign = TextAlign.Start,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Possui centro obstétrico? ${changeValue(EstablishmentStateHolder.establishment.centroObstetrico)}",
                textAlign = TextAlign.Start,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Possui centro neonatal? ${changeValue(EstablishmentStateHolder.establishment.centroNeonatal)}",
                textAlign = TextAlign.Start,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Possui atendimento hospitalar? ${changeValue(EstablishmentStateHolder.establishment.atendimentoHospitalar)}",
                textAlign = TextAlign.Start,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Possui serviço de apoio? ${changeValue(EstablishmentStateHolder.establishment.servicoApoio)}",
                textAlign = TextAlign.Start,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Possui atendimento ambulatorial? ${changeValue(EstablishmentStateHolder.establishment.atendimentoAmbulatorial)}",
                textAlign = TextAlign.Start,
                fontSize = 18.sp
            )
        }

    }
}

fun changeValue(value: String): String {
    return if (value == "1") {
        "Sim"
    } else {
        "Não"
    }
}


// Pré-visualização da tela de detalhes (para visualizar o layout durante o desenvolvimento)
@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
//    val navController = rememberNavControler()
//    DetailsScreen(navController)
}