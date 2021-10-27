package com.example.week3day4p1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var textViewName =findViewById<TextView>(R.id.textViewName)

        var name = intent.getStringExtra("item")
          textViewName.text = name
    }
}