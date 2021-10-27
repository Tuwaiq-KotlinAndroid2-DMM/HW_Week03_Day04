package com.example.week3_day4_practice2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.remove)

        var textView = findViewById<TextView>(R.id.textView)
        var view = intent.getStringExtra("item")
        textView.text = view.toString()


    }
}