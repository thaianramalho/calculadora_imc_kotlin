package com.ramalho.calculadora_imc_kotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val peso = findViewById<EditText>(R.id.Peso)
        val altura = findViewById<EditText>(R.id.Altura)
        val resultado = findViewById<TextView>(R.id.Resultado)
        val calcular = findViewById<Button>(R.id.Calcular)
        val hideKeyboard = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        calcular.setOnClickListener {
            try {
                val pesoD = peso.text.toString().toDouble()
                val alturaD = altura.text.toString().toDouble()

                val imcGrande = pesoD / (alturaD * alturaD)
                val imc = String.format("%.2f", imcGrande).toDouble()
                hideKeyboard.hideSoftInputFromWindow(currentFocus?.windowToken, 0)

                if (imc < 18.5) {
                    resultado.text = "Seu IMC é: $imc \nAbaixo do peso"
                } else if (imc < 25) {
                    resultado.text = "Seu IMC é: $imc \nPeso normal"
                } else if (imc < 30) {
                    resultado.text = "Seu IMC é: $imc \nSobrepeso"
                } else {
                    resultado.text = "Seu IMC é: $imc \nObesidade"
                }
            } catch (e: NumberFormatException) {
                resultado.text = "Insira um valor válido"
            }
        }


    }
}