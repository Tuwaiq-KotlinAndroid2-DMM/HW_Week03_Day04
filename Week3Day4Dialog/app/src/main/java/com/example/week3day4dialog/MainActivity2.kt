package com.example.week3day4dialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var viewUsers=findViewById<TextView>(R.id.Result)
        var result=intent.getStringExtra("Name")
        viewUsers.text = result.toString()
    }
}