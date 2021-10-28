package com.example.w3d4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var listView = findViewById<ListView>(R.id.listView)
        var button = findViewById<Button>(R.id.butoonadd)
        var buttonRemove = findViewById<Button>(R.id.butoonremov)
        var users = mutableListOf<String>(
            "Ali",
            "Sara",
            "Ghzlan",
        )
        var uListAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, users)
        listView.adapter = uListAdapter

        listView.setOnItemClickListener { parent, view, position, id ->
            var item = parent.getItemAtPosition(position) as String
            Toast.makeText(this, "Postion: $position,value: $item", Toast.LENGTH_LONG).show()

            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("Name", item)
            startActivity(intent)
        }


        button.setOnClickListener {

            /* users.add("khalid")
            uListAdapter.notifyDataSetChanged()*/
            var dialogView = layoutInflater.inflate(R.layout.custom_layout, null)
            var customDialog = AlertDialog.Builder(this)
                .setView(dialogView)
                .show()
            var dButtonAdd = dialogView.findViewById<Button>(R.id.button5)
            var editTextDialog = dialogView.findViewById<EditText>(R.id.editTextName)

            dButtonAdd.setOnClickListener {
                var name = editTextDialog.text.toString()
                if (!name.isEmpty()) {
                    users.add(name)
                    uListAdapter.notifyDataSetChanged()
                    customDialog.dismiss()

                } else {
                    Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_SHORT).show()
                }
            }


        }

        buttonRemove.setOnClickListener {

            /*users.removeLastOrNull()
        uListAdapter.notifyDataSetChanged()*/


            var removeDialog = layoutInflater.inflate(R.layout.activity_dialog_spinner, null)
            var customDialog = AlertDialog.Builder(this)
                .setView(removeDialog)
                .show()
            var dButtonRemove = removeDialog.findViewById<Button>(R.id.buttonRemove)
            var spinnerRemove = removeDialog.findViewById<Spinner>(R.id.spinner)
            var spinnerRemoveList =
                ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, users)
            spinnerRemove.adapter = spinnerRemoveList


            dButtonRemove.setOnClickListener {


                var selectedItem = spinnerRemove.selectedItem
                //var name = spinnerRemove.toString()
                users.remove(selectedItem)
                uListAdapter.notifyDataSetChanged()
                customDialog.dismiss()
            }
        }
    }}




           /* dButtonRemove.setOnClickListener {
                var name = spinnerRemove.toString()
                if (!name.isEmpty()) {
                    users.remove(name)
                    uListAdapter.notifyDataSetChanged()
                    customDialog.dismiss()

                } else {
                    Toast.makeText(this, "Removed", Toast.LENGTH_SHORT).show()
                }


            }*/
