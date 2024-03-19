package br.com.fiap.smarthealthmap.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.smarthealthmap.R
import br.com.fiap.smarthealthmap.model.Establishment
import br.com.fiap.smarthealthmap.service.EstablishmentResponse
import br.com.fiap.smarthealthmap.service.EstablishmentServiceFactory
import br.com.fiap.smarthealthmap.service.EstablishmentsStateHolder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun LandingScreen(navController : NavController) {

    var establishmentState by remember { mutableStateOf(emptyList<Establishment>()) }

    val call =
        EstablishmentServiceFactory()
        .getEstablishmentService()
        .getEstablishments("35")

    call.enqueue(object : Callback<EstablishmentResponse>{
        override fun onResponse(
            call: Call<EstablishmentResponse>,
            response: Response<EstablishmentResponse>
        ) {
            if (response.isSuccessful){
                val establishmentResponse = response.body()
                establishmentState  = establishmentResponse?.estabelecimentos ?: emptyList()
                EstablishmentsStateHolder.establishmentsState = establishmentState
            }
        }

        override fun onFailure(call: Call<EstablishmentResponse>, t: Throwable) {
            Log.i("ERROR", t.message.toString())
        }
    })

    LaunchedEffect(navController) {
        navController.navigate("establishments")
    }


    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp)
        ) {
            Image(
                modifier = Modifier.size(180.dp, 220.dp),
                painter = painterResource(id = R.drawable.home_blue_rectagle),
                contentScale = ContentScale.Crop,
                contentDescription = "Detalhe da pagina"
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(110.dp, 220.dp),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo da smart health map"
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom
        ) {
            Image(
                alignment = Alignment.BottomEnd,
                modifier = Modifier
                    .size(170.dp, 220.dp)
                    .offset(x = (10).dp),
                painter = painterResource(id = R.drawable.home_red_rectagle),
                contentScale = ContentScale.Crop,
                contentDescription = "Detalhe da pagina"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LandingScreenPreview() {
    //LandingScreen()
}