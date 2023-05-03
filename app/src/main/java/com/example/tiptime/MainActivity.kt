package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calcular.setOnClickListener{ calculateTip() }
    }
    fun calculateTip() {
        val stringInTextField = binding.preco.text.toString()
        val cost = stringInTextField.toDouble()
        val selectedId = binding.tipOptions.checkedRadioButtonId
        val tipPercentage = when (selectedId) {
            R.id.vinte -> 0.20
            R.id.dezoito -> 0.18
            else -> 0.15

        }
        var tip = tipPercentage * cost
        val roundUp = binding.gorjetaAtivo.isChecked
        if (roundUp) {
            tip = kotlin.math.ceil(tip)
        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.resultadoDaGorjeta.text = getString(R.string.resultadoDaGorjeta, formattedTip)
    }

}