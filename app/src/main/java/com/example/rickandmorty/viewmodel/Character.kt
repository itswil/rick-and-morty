package com.example.rickandmorty.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.api.APIService
import com.example.rickandmorty.model.Character
import com.example.rickandmorty.model.Info
import com.example.rickandmorty.model.Response
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {
    private val initialCharacterResponse = Response<Character>(
        info = Info(
            count = 0,
            pages = 0,
            next = "",
            prev = "",
        ), results = emptyList()
    )
    private val _characterResponse = mutableStateOf(initialCharacterResponse)
    var errorMessage: String by mutableStateOf("")

    val characterResponse: MutableState<Response<Character>>
        get() = _characterResponse

    fun getCharacterResponse() {
        viewModelScope.launch {
            val apiService = APIService.getInstance()
            try {
                _characterResponse.value = apiService.getCharacters()

            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}