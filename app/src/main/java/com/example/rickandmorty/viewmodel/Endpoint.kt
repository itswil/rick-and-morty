package com.example.rickandmorty.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.api.APIService
import com.example.rickandmorty.model.*
import kotlinx.coroutines.launch

class EndpointViewModel : ViewModel() {
    private val apiService = APIService.getInstance()
    private val initialCharacterResponse = Response<Character>(info = Info(), results = emptyList())
    private val _characterResponse = mutableStateOf(initialCharacterResponse)
    private val initialLocationResponse = Response<Location>(info = Info(), results = emptyList())
    private val _locationResponse = mutableStateOf(initialLocationResponse)
    private val initialEpisodeResponse = Response<Episode>(info = Info(), results = emptyList())
    private val _episodeResponse = mutableStateOf(initialEpisodeResponse)

    var errorMessage: String by mutableStateOf("")

    val characterResponse: MutableState<Response<Character>>
        get() = _characterResponse


    fun getCharacterResponse() {
        viewModelScope.launch {
            try {
                _characterResponse.value = apiService.getCharacters()
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    val locationResponse: MutableState<Response<Location>>
        get() = _locationResponse

    fun getLocationResponse() {
        viewModelScope.launch {
            try {
                _locationResponse.value = apiService.getLocations()
                println(_locationResponse.value)
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    val episodeResponse: MutableState<Response<Episode>>
        get() = _episodeResponse

    fun getEpisodeResponse() {
        viewModelScope.launch {
            try {
                _episodeResponse.value = apiService.getEpisodes()
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}