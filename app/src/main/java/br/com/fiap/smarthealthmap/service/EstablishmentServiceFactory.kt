package br.com.fiap.smarthealthmap.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EstablishmentServiceFactory {
    private val base_url : String = "https://apidadosabertos.saude.gov.br/cnes/"

    private val establishmentService = Retrofit
        .Builder()
        .baseUrl(base_url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getEstablishmentService() : EstablishmentService{
        return establishmentService.create(EstablishmentService::class.java)
    }
}
