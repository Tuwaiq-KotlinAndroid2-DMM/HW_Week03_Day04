package com.twqe.lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.*
import androidx.appcompat.app.AlertDialog
import android.widget.ArrayAdapter

import android.widget.Spinner





class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var listViewU = findViewById<ListView>(R.id.listViewUsers)

//        create list for users list
        var users = mutableListOf(
            "asma",
            "ahmed",
            "ali"
        )
//      create   adapter for the users
        var uListAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, users)
//        ste the adapter
        listViewU.adapter = uListAdapter
        listViewU.setOnItemClickListener { parent, view, position, id ->
            var item = parent.getItemAtPosition(position) as String
//    Toast.makeText(this, "position: $position, value: $item", Toast.LENGTH_LONG).show()
            // I assume Page.class is your second ativity
            var intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("user", item)// getText() SHOULD NOT be static!!!
            startActivity(intent)
        }
        var btnAdd = findViewById<Button>(R.id.buttonAdd)
        var btnRemove = findViewById<Button>(R.id.buttonRemove)
        btnAdd.setOnClickListener {
            var dialogView = layoutInflater.inflate(R.layout.dialog_custum_layout, null)
            var customDialog = AlertDialog.Builder(this)
                .setView(dialogView)
                .show()
            var dButtonAdd = dialogView.findViewById<Button>(R.id.button1)
            var spinner = dialogView.findViewById<Spinner>(R.id.spinner)
            spinner.adapter =ArrayAdapter(this, android.R.layout.simple_spinner_item, users)
            dButtonAdd.setOnClickListener {

                var itemS = spinner.selectedItem.toString()
                users.remove(itemS)
                uListAdapter.notifyDataSetChanged()
                customDialog.dismiss()


        }
            var editTextTextPersonName=findViewById<EditText>(R.id.editTextTextPersonName)
        btnRemove.setOnClickListener {
            var name=editTextTextPersonName.text.toString()
            users.add(name)
            uListAdapter.notifyDataSetChanged()
        }
    }
}}








