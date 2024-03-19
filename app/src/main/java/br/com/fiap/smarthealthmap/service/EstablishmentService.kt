package br.com.fiap.smarthealthmap.service

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface EstablishmentService {
    @GET("estabelecimentos")
    fun getEstablishments(
        @Query("codigo_uf") uf : String,
        @Query("status") status : Int = 1
    ) : Call<EstablishmentResponse>
}