package com.example.listview2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class userInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)
        var nameTextView= findViewById<TextView>(R.id.textViewName)
        var name= intent.getStringExtra("name")
        nameTextView.text=name
    }
}