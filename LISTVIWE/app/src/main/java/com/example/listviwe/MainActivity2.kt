package com.example.listviwe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

//        var textViwe=findViewById<TextView>(R.id.textViewim)
        var textView = findViewById<TextView>(R.id.textView)
        var u=intent.getStringExtra("user")
        textView.text= u
    }
}