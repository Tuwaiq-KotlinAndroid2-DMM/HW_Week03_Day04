package com.example.w3d4t2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var txtvew=findViewById<TextView>(R.id.textView)
        txtvew.text= intent.getStringExtra("name")
    }
}