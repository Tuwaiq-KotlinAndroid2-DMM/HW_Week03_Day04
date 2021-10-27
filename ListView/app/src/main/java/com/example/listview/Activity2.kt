package com.example.listview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        var NameTextView = findViewById<TextView>(R.id.TextViewUserName)
        var name = intent.getStringExtra("name")
        NameTextView.text="User: $name"
    }
}