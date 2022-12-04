package com.example.amphibians.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

//Membuat variabel BASE_URL untuk mendefinisikan master URL dari flie JSON
private const val BASE_URL =
    "https://raw.githubusercontent.com/GalihSetya/FileJson/main/"


//Membuat objek Moshi dengan adaptor Kotlin yang akan digunakan Retrofit untuk mengparse JSON
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

//Membuat objek Retrofit dengan konverter Moshi
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

// interface PlanetApiService yang memanggil file JSON
interface AmphibianApiService {
    //Mendeklarasikan methid GET untuk mendapatkan daftar amfibi dari master URL
    @GET("db.json")
    suspend fun getAmphibians() : List<Amphibian>
}

//Buat objek yang menyediakan layanan lazy-initialized retrofit service
object AmphibianApi {
    val retrofitService: AmphibianApiService by lazy {
        retrofit.create(AmphibianApiService::class.java)
    }
}

