package com.example.week3day4p1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var listViewU = findViewById<ListView>(R.id.ListViewUser)
        var butADD = findViewById<Button>(R.id.DialogAdd)
        var buttRemo = findViewById<Button>(R.id.buttonRemove)

        var users = mutableListOf<String>("Nora", "Beba", "Noje", "Sara", "Ali", "Mohamed","Khaled")

        var uListAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, users)

        listViewU.adapter = uListAdapter

        listViewU.setOnItemClickListener { parent, view, position, id ->

            var item = parent.getItemAtPosition(position) as String



            var intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("item", item)
            startActivity(intent)

        }

        butADD.setOnClickListener {

            var dialogVie = layoutInflater.inflate(R.layout.dialog_custom_layout, null) //make xml object to use it in code
            var customDi = AlertDialog.Builder(this)
                .setView(dialogVie)
                .show()


            var dButAdd = dialogVie.findViewById<Button>(R.id.DialogAdd) // becuse the buttom chiled
            var editTextViewDia = dialogVie.findViewById<EditText>(R.id.DialogTextViewName)


            dButAdd.setOnClickListener {
                var name = editTextViewDia.text.toString()
                if (!name.isEmpty()) {
                    users.add(name)
                    uListAdapter.notifyDataSetChanged()
                    customDi.dismiss()


                } else {
                    Toast.makeText(this, "Name can not be empty", Toast.LENGTH_SHORT).show()
                }
            }

        }

        buttRemo.setOnClickListener {

            users.removeLast()
            uListAdapter.notifyDataSetChanged()
        }


    }
}