package com.rodrigojbarrera.ipicto

data class Pictograms(
    val _id: Int = -1,
    val keywords: List<Keyword> = listOf(),
    val schematic: Boolean = false,
    val sex: Boolean = false,
    val violence: Boolean = false,
    val created: String = "",
    val lastUpdate: String = "",
    val downloads: Int = -1,
    val categories: List<String> = listOf(),
    val synsets: List<String> = listOf(),
    val tags: List<String> = listOf(),
    val desc: String = "",
    val hair: Boolean = false,
    val skin: Boolean = false,
    val aacColor: Boolean = false,
    val aac: Boolean = false

)

data class Keyword(
    val idKeyword: Int = -1,
    val keyword: String = "",
    val plural : String = "",
    val idLocution:String="",
    val meaning:String ="",
    val type : Int = -1,
    val lse : Int = -1,
){
    override fun toString(): String = keyword
}

data class PictoList (val results: List<Pictograms> = listOf())



