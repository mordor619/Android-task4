package com.example.task4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class LossActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loss)

        val num = intent.getIntExtra("num", 0)

        findViewById<TextView>(R.id.resultView).text = "$num"

    }
}