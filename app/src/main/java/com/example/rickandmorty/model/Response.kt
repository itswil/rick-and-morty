package com.example.rickandmorty.model

data class Info(
    val count: Int = 0,
    val pages: Int = 0,
    val next: String = "",
    val prev: String = "",
)

data class Response<T>(
    val info: Info,
    val results: List<T> = emptyList(),
)