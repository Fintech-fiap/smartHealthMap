package br.com.fiap.smarthealthmap.model

import com.google.gson.annotations.SerializedName

 data class Establishment(
     @SerializedName("nome_fantasia")
     val nome : String = "",
     @SerializedName("codigo_uf")
     val codigoUf : String = "",
     @SerializedName("endereco_estabelecimento")
     val logradouro : String = "",
     @SerializedName("numero_estabelecimento")
     val numero : String = "",
     @SerializedName("bairro_estabelecimento")
     val bairro : String = "",
     @SerializedName("codigo_cep_estabelecimento")
     val cep : String = "",
     @SerializedName("endereco_email_estabelecimento")
     val email : String = "",
     @SerializedName("numero_telefone_estabelecimento")
     val telefone : String = "",
     @SerializedName("descricao_turno_atendimento")
     val turnos : String = "",
     @SerializedName("latitude_estabelecimento_decimo_grau")
     val latitude : String = "",
     @SerializedName("longitude_estabelecimento_decimo_grau")
     val longitude : String = "",
     @SerializedName("estabelecimento_possui_centro_cirurgico")
     val centroCirurgico : String = "",
     @SerializedName("estabelecimento_possui_centro_obstetrico")
     val centroObstetrico : String = "",
     @SerializedName("estabelecimento_possui_centro_neonatal")
     val centroNeonatal : String = "",
     @SerializedName("estabelecimento_possui_atendimento_hospitalar")
     val atendimentoHospitalar : String = "",
     @SerializedName("estabelecimento_possui_servico_apoio")
     val servicoApoio : String = "",
     @SerializedName("estabelecimento_possui_atendimento_ambulatorial")
     val atendimentoAmbulatorial : String = "",
     @SerializedName("estabelecimento_faz_atendimento_ambulatorial_sus")
     val atendimentoAmbulatorialSUS : String = "",
 )