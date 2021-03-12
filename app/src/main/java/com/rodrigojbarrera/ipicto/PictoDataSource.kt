package com.rodrigojbarrera.ipicto

class PictoDataSource (private val webService: WebService) {

    suspend fun getPictoToys() : List<Pictograms> = webService.getPictoToys("es")
}