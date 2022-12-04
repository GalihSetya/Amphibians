package com.example.amphibians.network

import com.squareup.moshi.Json
/**
 * This data class defines an Amphibian which includes the amphibian's name, the type of
 * amphibian, and a brief description of the amphibian.
 * The property names of this data class are used by Moshi to match the names of values in JSON.
 */
// data class ini mendefinisikan Amfibi yang mencakup nama amfibi, jenisnya
// amfibi, dan penjelasan singkat tentang amfibi.
// Nama variabel data class ini digunakan oleh Moshi untuk mencocokkan nama nilai di JSON.
data class Amphibian(
    val name: String,
    @Json(name = "image") val imageSrc: String,
    val type: String,
    val description: String
)
