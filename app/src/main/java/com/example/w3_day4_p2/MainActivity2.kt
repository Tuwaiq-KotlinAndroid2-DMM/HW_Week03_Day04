package com.example.w3_day4_p2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var username = intent.getStringExtra("Name")
        var textView = findViewById<TextView>(R.id.textViewName)
        textView.text = username


    }
}