package com.example.rickandmorty.model

data class Info(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String,
)

data class Response<T>(
    val info: Info,
    val results: List<T>,
)