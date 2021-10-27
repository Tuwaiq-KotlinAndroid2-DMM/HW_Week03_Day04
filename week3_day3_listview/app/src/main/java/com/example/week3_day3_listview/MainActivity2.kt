package com.example.week3_day3_listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var textViewResult=findViewById<TextView>(R.id.textViewResult)
        var result=intent.getStringExtra("user")
        textViewResult.text=result.toString()
    }
}