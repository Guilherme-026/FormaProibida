package com.example.formasproibidas.funcoes

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    private var _nome = mutableStateOf("")
    val nome: State<String> get() = _nome

    fun setNome(nome: String){
        _nome.value = nome
    }
}