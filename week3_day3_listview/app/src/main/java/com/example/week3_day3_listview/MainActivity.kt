package com.example.week3_day3_listview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listViewUs = findViewById<ListView>(R.id.ListViewUsers)
        var buttonAdd = findViewById<Button>(R.id.buttonAdd)

        var buttonRemove = findViewById<Button>(R.id.buttonRemove)

        //create list of user
        var users = mutableListOf<String>(
            "Ali",
            "Mohammed",
            "Sara"
        )

        //create Adapter for the user list

        var uListAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, users)

        //set the adapter
        listViewUs.adapter = uListAdapter

        listViewUs.setOnItemClickListener { parent, view, position, id ->
            var item = parent.getItemAtPosition(position) as String
            Toast.makeText(this, "position: $position ,values: $item", Toast.LENGTH_LONG).show()
            var intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("user", item)
            startActivity(intent)

        }
        buttonAdd.setOnClickListener {
            var dialogView = layoutInflater.inflate(R.layout.custome_alert, null)
            var custome_alert = AlertDialog.Builder(this)
                .setView(dialogView)
                .show()
            /*        users.add("Khaled")
            uListAdapter.notifyDataSetChanged()*/
            var button2 = dialogView.findViewById<Button>(R.id.button)
            var editTextDialog = dialogView.findViewById<EditText>(R.id.textInputLayout)

            button2.setOnClickListener {
                var name = editTextDialog.text.toString()
                if (!name.isEmpty()) {
                    users.add(name)
                    uListAdapter.notifyDataSetChanged()
                    custome_alert.dismiss()

                } else {
                    Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_SHORT).show()
                }
            }

        }
        buttonRemove.setOnClickListener {

            var dialogView = layoutInflater.inflate(R.layout.spinner_dialog, null)
            var spinner_dialog = AlertDialog.Builder(this)
                .setView(dialogView)
                .show()

            var spinnerList=dialogView.findViewById<Spinner>(R.id.spinnerList)
            var buttonDel=dialogView.findViewById<Button>(R.id.buttonDel)

            var spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, users)
            spinnerList.adapter = spinnerAdapter
            buttonDel.setOnClickListener {
                
            var items=spinnerList.selectedItem.toString()
            users.remove(items)
            uListAdapter.notifyDataSetChanged()
            spinner_dialog.dismiss()
            }

/*  users.remove("Sara")
                uListAdapter.notifyDataSetChanged()*/
        }
    }
}