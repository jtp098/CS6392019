package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)

        rollButton.setOnClickListener { rollDice() }

        val countButton: Button = findViewById(R.id.count_button)
        countButton.setOnClickListener { countIt() }

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener { reset() }

    }

    private fun rollDice() {
        val resultText: TextView = findViewById(R.id.result_text)
        val randomInt = Random().nextInt(6) + 1
        resultText.text = randomInt.toString()

       // resultText.text = "Dice Rolled!"
        //Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()

    }

    private fun countIt(){
        val resultText: TextView = findViewById(R.id.result_text)

        if(resultText.text == "Hello World!"){
            resultText.text = "1"
        }else{
            var result = resultText.text.toString().toInt()

            if(result <6){
                result++
                resultText.text = result.toString()
            }
        }
    }

    private fun reset(){
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = "0"


    }
}
