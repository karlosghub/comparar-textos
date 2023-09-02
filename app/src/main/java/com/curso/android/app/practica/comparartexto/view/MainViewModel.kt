package com.curso.android.app.practica.comparartexto.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curso.android.app.practica.comparartexto.model.Texts
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private var _texts = MutableLiveData(Texts("","").toString())
    val texts: LiveData<String> get() = _texts
    private var devolucion = ""
    fun result(campo1:String, campo2:String): String {
        viewModelScope.launch {
            devolucion = if (campo1.isEmpty()||campo2.isEmpty() || (campo1.isEmpty()&&campo2.isEmpty())) {
                "Ingrese texto en ambos campos"
            } else {
                if (campo1 == campo2) {
                    "Los textos son iguales"
                } else {
                    "Los textos no son iguales"
                }
            }
        }
        return devolucion
    }
}