package com.rodrigojbarrera.ipicto

interface PictoRepository {

    suspend fun getPictoToys() : List<Pictograms>
}