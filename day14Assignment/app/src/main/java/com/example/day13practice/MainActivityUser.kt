package com.example.day13practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivityUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_user)

        var name = intent.getStringExtra("name")

        findViewById<TextView>(R.id.textViewUser).text = name
    }
}