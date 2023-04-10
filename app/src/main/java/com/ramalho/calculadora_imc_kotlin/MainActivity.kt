package com.ramalho.calculadora_imc_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        calcular.setOnClickListener {
            try {
                val pesoD = peso.text.toString().toDouble()
                val alturaD = altura.text.toString().toDouble()

                val imc = pesoD / (alturaD * alturaD)

                if (imc < 18.5) {
                    resultado.text = "Abaixo do peso"
                } else if (imc < 25) {
                    resultado.text = "Peso normal"
                } else if (imc < 30) {
                    resultado.text = "Sobrepeso"
                } else {
                    resultado.text = "Obesidade"
                }
            } catch (e: NumberFormatException) {
                resultado.text = "Insira um valor válido"
            }
        }


    }
}