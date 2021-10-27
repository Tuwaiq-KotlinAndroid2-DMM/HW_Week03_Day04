package com.twq.listview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var listViewU = findViewById<ListView>(R.id.listViewUsers)
        var buttonAdd = findViewById<Button>(R.id.buttonRemoveDialog)
        var buttonRemove = findViewById<Button>(R.id.buttonRemove)


        // create list for users
        var users = mutableListOf<String>(
            "Ali",
            "Mohammed",
            "Sara",
        )

        // create adapter for the users list

        var uListAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, users)

        //set the adapter
        listViewU.adapter = uListAdapter

        // parent = item, view = layout,
        listViewU.setOnItemClickListener { parent, view, position, id ->


            var item = parent.getItemAtPosition(position) as String
            Toast.makeText(
                this, "Position: $position, Value: $item",
                Toast.LENGTH_SHORT
            ).show()
            var userIntent = Intent(this, userSelected::class.java)
            userIntent.putExtra("user", item)
            userIntent.putExtra("position", position)

            startActivity(userIntent)
        }

        buttonAdd.setOnClickListener {
            var dialogView = layoutInflater.inflate(R.layout.dialog_custom_layout, null)

            var coustomDialog = AlertDialog.Builder(this)
                .setView(dialogView)
                .show()
            // link dialog buttons
            var buttonAddDialog = dialogView.findViewById<Button>(R.id.buttonRemoveDialog)
            var editTextDialog = dialogView.findViewById<EditText>(R.id.editTextusernameDialog)
            buttonAddDialog.setOnClickListener {
                var name = editTextDialog.text.toString()
                if (!name.isEmpty()) {
                    users.add(name)
                    uListAdapter.notifyDataSetChanged()
                    coustomDialog.dismiss()
                } else {
                    Toast.makeText(
                        this, "Name cannot be empty",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        buttonRemove.setOnClickListener {
            var removeDialogInflater = layoutInflater.inflate(
                R.layout.dialog_custom_layout_remove,
                null
            )
            var removeDialog = AlertDialog.Builder(this)
                .setView(removeDialogInflater)
                .show()
            var mySpinner = removeDialogInflater.findViewById<Spinner>(
                R.id.spinnerListOfUsers
            )
            var spinnerListAdapter = ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, users)

            mySpinner.adapter = spinnerListAdapter

            var layoutRemoveButton = removeDialogInflater.findViewById<Button>(
                R.id.buttonRemoveDialog
            )

            layoutRemoveButton.setOnClickListener {
                var nameToBeRemoved = mySpinner.selectedItem
                users.remove(nameToBeRemoved)
                uListAdapter.notifyDataSetChanged()
                removeDialog.dismiss()
            }

        }
    }
}