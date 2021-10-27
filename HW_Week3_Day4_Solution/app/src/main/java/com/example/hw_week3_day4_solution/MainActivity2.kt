package com.example.hw_week3_day4_solution

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog2)
var username = intent.getStringExtra("name")
        var textView = findViewById<TextView>(R.id.textView3)
        textView.text = username
    }
}