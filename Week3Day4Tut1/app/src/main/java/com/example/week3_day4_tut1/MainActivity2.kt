package com.example.week3_day4_tut1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var textViewUserName = findViewById<TextView>(R.id.textViewUserName)
        var  result = intent.getStringExtra("user")
        textViewUserName.text="Name\n"+result.toString()
    }
}