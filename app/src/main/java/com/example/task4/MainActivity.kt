package com.example.task4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    var numEntered = 0;
    var chances = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edt1 = findViewById<TextInputEditText>(R.id.edt1)
        val tv2 = findViewById<TextView>(R.id.tv2)
        val tv3 = findViewById<TextView>(R.id.tv3)

        val randomNum = (0..1000).random()

        println("random no: $randomNum")

        tv2.setOnClickListener {

            if (edt1.text.toString().isNullOrEmpty()) {
                tv3.text = "Please enter a number!"
            } else {

                numEntered = edt1.text.toString().toInt()


                if (numEntered == randomNum) {
                    val winIntent = Intent(this, EndGameActivity::class.java)
                    winIntent.putExtra("num", randomNum)
                    startActivity(winIntent)

                } else if (numEntered > randomNum) {

                    tv3.text = "No :) My number is smaller"
                } else if (numEntered < randomNum) {

                    tv3.text = "No :) My number is bigger"
                }

                chances++

                if (chances == 12) {
                    val lossIntent = Intent(this, LossActivity::class.java)
                    lossIntent.putExtra("num", randomNum)
                    startActivity(lossIntent)
                }

            }
        }

    }
}