package com.rodrigojbarrera.ipicto

class PictoRepositoryImpl(private val dataSource: PictoDataSource) : PictoRepository {

    override suspend fun getPictoToys(): List<Pictograms> = dataSource.getPictoToys()
}