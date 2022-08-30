package com.example.the17odsapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModel(var puntuacionF: Int ) : ViewModel() {

    private val _puntuacion = MutableLiveData(puntuacionF)
    val puntuacion: LiveData<Int> get() = _puntuacion


    fun incremento() {
        _puntuacion.value = _puntuacion.value?.plus(1)

    }

    //init {
      //  _puntuacion.value = puntuacionF
    //}

}

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(private var puntuacion: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(puntuacion) as T
    }

}