package br.com.fiap.smarthealthmap.service

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import br.com.fiap.smarthealthmap.model.Establishment

object EstablishmentStateHolder {
    var establishment by mutableStateOf(Establishment())
}