package br.com.fiap.smarthealthmap.screens

import android.util.Log
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.smarthealthmap.R
import br.com.fiap.smarthealthmap.model.Establishment
import br.com.fiap.smarthealthmap.service.EstablishmentStateHolder
import br.com.fiap.smarthealthmap.service.EstablishmentsStateHolder
import br.com.fiap.smarthealthmap.ui.theme.poppings

@Composable
fun EstablishmentsScreen(navController : NavController) {
    Column(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxSize(),
    ){
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                modifier = Modifier.size(32.dp, 32.dp),
                painter = painterResource(id = R.drawable.small_logo),
                contentDescription = "Logomarca"
            )
            Text(
                centerLetterWithColor("SHM"),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = poppings

            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Unidades de saúde",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                fontFamily = poppings
            )
        }
        Spacer(modifier = Modifier.height(2.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Selecione alguma opção para mais informações",
                fontFamily = poppings
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            LazyColumn(
            ){
                items(
                    EstablishmentsStateHolder.establishmentsState
                ) {
                    EstablishmentCard(navController, it)
                }
            }
        }
    }
}

@Composable
fun EstablishmentCard(navController : NavController, establishment: Establishment) {
    Card(
        modifier = Modifier
            .padding(bottom = 8.dp)
            .height(60.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .height(60.dp)
                .padding(8.dp)

        ) {
            ClickableText(
                modifier = Modifier.width(300.dp),
                text = clickableText(establishment.nome),
                style = TextStyle(
                    fontFamily = poppings
                ),
                onClick = {
                    navController.navigate("details")
                    EstablishmentStateHolder.establishment = establishment
                }
            )
            Text(text = "")
        }
    }
}

fun clickableText(text : String) : AnnotatedString {
    val annotatedString = buildAnnotatedString {
        for ((index, char) in text.withIndex()) {
            append(char)
        }
    }

    return  annotatedString
}

fun centerLetterWithColor(text : String): AnnotatedString {
    val centerIndex = text.length / 2
    val annotatedString = buildAnnotatedString {
        for ((index, char) in text.withIndex()) {
            if (index == centerIndex) {
                withStyle(style = SpanStyle(color = Color.Red)) {
                    append(char)
                }
            } else {
                append(char)
            }
        }
    }
    return annotatedString
}

@Preview(showBackground = true)
@Composable
fun EstablishmentsScreenPreview() {
    //EstablishmentsScreen()
}