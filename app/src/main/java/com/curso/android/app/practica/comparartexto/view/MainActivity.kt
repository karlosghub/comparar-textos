package com.curso.android.app.practica.comparartexto.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.curso.android.app.practica.comparartexto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var campo1 = ""
        var campo2 = ""
        binding.buttonComparar.setOnClickListener {
            mainViewModel.texts.observe(this) {
                campo1 = binding.input1.text.toString()
                campo2 = binding.input2.text.toString()
            }
            binding.resultado.text = mainViewModel.result(campo1, campo2)
        }
        binding.input1.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.input2.addTextChangedListener(object: TextWatcher {
                    override fun afterTextChanged(p0: Editable?) {
                        binding.resultado.text = "Resultado"
                    }
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                    }
                )
            }
        }
        )
        binding.input2.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.input1.addTextChangedListener(object: TextWatcher {
                    override fun afterTextChanged(p0: Editable?) {
                        binding.resultado.text = "Resultado"
                    }
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                }
                )
            }
        }
        )
        binding.buttonReiniciar.setOnClickListener {
                binding.input1.text = null
                binding.input2.text = null
                binding.resultado.text = "Resultado"
        }
    }
}