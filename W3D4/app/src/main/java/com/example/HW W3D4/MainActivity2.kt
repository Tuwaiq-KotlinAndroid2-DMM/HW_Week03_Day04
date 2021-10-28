package com.example.w3d4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var textView = findViewById<TextView>(R.id.Ghzlan)
        var str = intent.getStringExtra("item")
        textView.text = str

    }
}