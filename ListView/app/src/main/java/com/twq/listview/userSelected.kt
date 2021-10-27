package com.twq.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class userSelected : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_selected)
        var textViewResult = findViewById<TextView>(R.id.textViewResult)
        var result= intent.getStringExtra("user")
        var position = intent.getIntExtra("position",-1)

        textViewResult.text = "Selected User: $result \nPosition in list: ${position +1}"

    }
}