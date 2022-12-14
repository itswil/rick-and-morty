package com.example.rickandmorty.api

import com.example.rickandmorty.model.Character
import com.example.rickandmorty.model.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://rickandmortyapi.com/api/"

interface APIService {
    @GET("character")
    suspend fun getCharacters(): Response<Character>

    companion object {
        private var apiService: APIService? = null

        fun getInstance(): APIService {
            if (apiService == null) {
                apiService = Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build()
                    .create(APIService::class.java)
            }
            return apiService!!
        }
    }
}