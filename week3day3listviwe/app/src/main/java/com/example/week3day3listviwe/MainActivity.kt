package com.example.week3day3listviwe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var layoutitem=findViewById<LinearLayout>(R.id.layoutItem)
        var btnDele=findViewById<ImageView>(R.id.image)
        var btnAlarm=findViewById<ImageView>(R.id.image)

        btnDele.setOnClickListener{
        var alertDialog=AlertDialog.Builder(this)
            alertDialog.setTitle("btnDelet")
            alertDialog.setMessage("Do you want to exit")
            alertDialog.setPositiveButton("Yes"){dialog, which->
                btnAlarm.isVisible=false
            }
            alertDialog.setNegativeButton("NO"){dialog,which->
                dialog.cancel()
            }
            var exitdialog=alertDialog.create()
            exitdialog.show()
        }

    }
}