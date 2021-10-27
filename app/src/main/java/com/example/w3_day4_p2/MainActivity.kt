package com.example.w3_day4_p2

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
        var listViewU = findViewById<ListView>(R.id.listView)
        var buttonAdd = findViewById<Button>(R.id.buttonAdd)
        var buttonRemove = findViewById<Button>(R.id.buttonRemove)
//        create list for user
        var users = mutableListOf<String>("Najah", "Ali", "Sara")
//        create Adapter fot the user list
        var uListAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, users)

//        set the adapter
        listViewU.adapter = uListAdapter
        listViewU.setOnItemClickListener { parent, view, position, id ->
            var item = parent.getItemAtPosition(position) as String
            Toast.makeText(this, "Position: $position, Value: $item", Toast.LENGTH_SHORT).show()
            var intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("Name", "$item")
            startActivity(intent)
        }
        buttonAdd.setOnClickListener {
            var layoutDialog = layoutInflater.inflate(R.layout.mylayout, null)
//        create custome dialog
            var customDialog = AlertDialog.Builder(this)
                .setView(layoutDialog)
                .show()
//         call Dialog view
//        inflate the layout
            var dialogButton = layoutDialog.findViewById<Button>(R.id.DialogbuttonRemove)
            var editTextDialog = layoutDialog.findViewById<EditText>(R.id.EditTextUserNmae)

            dialogButton.setOnClickListener {
                var name = editTextDialog.text.toString()
                if (!name.isEmpty()) {
                    users.add(name)
                    uListAdapter.notifyDataSetChanged()
                    customDialog.dismiss()
                } else {
                    Toast.makeText(this, "Name Cannot be empty", Toast.LENGTH_SHORT).show()
                }
//            users.add("Lojain")
//            uListAdapter.notifyDataSetChanged()
            }
        }

        buttonRemove.setOnClickListener {
            var spinnerLayout = layoutInflater.inflate(R.layout.spinnerlayout, null)
//        create custome dialog
            var secCustomDialog = AlertDialog.Builder(this)
                .setView(spinnerLayout)
                .show()

            var spinner = spinnerLayout.findViewById<Spinner>(R.id.nameSpinner)
            val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, users)
            spinner.adapter = arrayAdapter
            var dbuttonRemove = spinnerLayout.findViewById<Button>(R.id.DialogbuttonRemove)

            var selectedUser: String? = null
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    selectedUser = spinner.selectedItem as String
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }

            dbuttonRemove.setOnClickListener {
                users.remove(selectedUser)
                Toast.makeText(this, "Removing user $selectedUser", Toast.LENGTH_SHORT).show()
                uListAdapter.notifyDataSetChanged()
                secCustomDialog.dismiss()
            }

        }
    }
}