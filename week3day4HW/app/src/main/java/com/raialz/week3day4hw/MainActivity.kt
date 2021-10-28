package com.raialz.week3day4hw

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listViewU = findViewById<ListView>(R.id.listViewUsers)
        var btnAdd = findViewById<Button>(R.id.buttonAdd)

        // create list for users
        var users = mutableListOf(
            "Ali",
            "Mohammad",
            "Sara",
        )

        // create adapter for the users list
        var uListAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,users)


        // set the adapter
        listViewU.adapter = uListAdapter

        listViewU.setOnItemClickListener { parent, view, position, id ->
            var item = parent.getItemAtPosition(position) as String
            Toast.makeText(this, "Postion: $position, Value: $item",
                Toast.LENGTH_LONG).show()
        }

        btnAdd.setOnClickListener {

            // inflate the layout
            var dialgView = layoutInflater.inflate(R.layout.lay,null)

            // create custom dialog
            var customDialog = AlertDialog.Builder(this)
                .setView(dialgView)
                .show()

            // call dialog`s views
            var dButtonAdd = dialgView.findViewById<Button>(R.id.textViewAddUser)
            var editTextDialog = dialgView.findViewById<EditText>(R.id.buttdailog)

            dButtonAdd.setOnClickListener {
                var name = editTextDialog.text.toString()
                if (!name.isEmpty()){
                    users.add(name)
                    uListAdapter.notifyDataSetChanged()
                    customDialog.dismiss()
                } else {
                    Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_SHORT).show()
                }
            }

        }

    }
}

