package br.com.fiap.smarthealthmap.screens

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.smarthealthmap.R

@Composable
fun LandingScreen() {
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
    LandingScreen()
}