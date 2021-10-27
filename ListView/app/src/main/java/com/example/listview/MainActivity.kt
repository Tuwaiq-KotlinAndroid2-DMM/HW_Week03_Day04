package com.example.listview

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

        var listViewU = findViewById<ListView>(R.id.listViewUsers)

        var btnAdd = findViewById<Button>(R.id.buttonAdd)
        var btnRemove = findViewById<Button>(R.id.buttonRemove)

        //Users list
        var listUsers = mutableListOf<String>(
            "Ghufran",
            "Fatimah",
            "Maryem"
        )

        //Create adapter for users list
        var uListAdapter =
            ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, listUsers)

        listViewU.adapter = uListAdapter

        listViewU.setOnItemClickListener { parent, view, position, id ->
            var item = parent.getItemAtPosition(position) as String
            //Toast.makeText(this, "Position: $position Value: $item", Toast.LENGTH_SHORT).show()
            var i = Intent(this, Activity2::class.java)
            i.putExtra("name", item)
            startActivity(i)
        }

        //Adding user
        btnAdd.setOnClickListener {
            var dialogView = layoutInflater.inflate(R.layout.custom_dialog, null)
            var customDialog = AlertDialog.Builder(this)
                .setView(dialogView)
                .show()

            //call dialog's views/components
            var dBtnAdd = dialogView.findViewById<Button>(R.id.dialogButtonAdd)
            var inputEditText = dialogView.findViewById<EditText>(R.id.dialogInputTextField)

            dBtnAdd.setOnClickListener {
                var name = inputEditText.text.toString()
                if(!name.isEmpty()){
                    listUsers.add(name)
                    uListAdapter.notifyDataSetChanged()
                    customDialog.dismiss()
                }
                else
                    Toast.makeText(this, "Name cannot be empty!", Toast.LENGTH_LONG).show()

            }
        }

        //Removing user
        btnRemove.setOnClickListener {
            var dialogView = layoutInflater.inflate(R.layout.remove_dialog,null)
            var removeDialog =AlertDialog.Builder(this)
                .setView(dialogView)
                .show()

            //call remove dialog components
            var dBtnRemove = dialogView.findViewById<Button>(R.id.removeDialogButtonRemove)
            var spinnerList = dialogView.findViewById<Spinner>(R.id.spinnerUsersList)
            var selected=""

            var uSpinnerAdapter =ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listUsers)
            spinnerList.adapter = uSpinnerAdapter

            spinnerList?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    selected = parent?.getItemAtPosition(position).toString()

                }

            }
            dBtnRemove.setOnClickListener {
                listUsers.remove(selected)
                uListAdapter.notifyDataSetChanged()
                removeDialog.dismiss()

            }
        }


    }
}