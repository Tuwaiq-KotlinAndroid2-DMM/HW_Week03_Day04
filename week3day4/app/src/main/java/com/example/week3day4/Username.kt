package com.example.week3day4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Username : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_username)

        var textView=findViewById<TextView>(R.id.textViewName)

        textView.text = intent.getStringExtra("name")
    }
}