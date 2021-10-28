package com.twq.hw14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listViewU=findViewById<ListView>(R.id.ListView)
        var buttonDelete =findViewById<Button>(R.id.buttonDelete)
        var buttomAdd= findViewById<Button>(R.id.buttonAdd)

        var user = mutableListOf<String>("mashael","manahil")
        var ulistAdapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,user)

        listViewU.adapter=ulistAdapter

        listViewU.setOnItemClickListener { parent, view, position, id ->
            var item= parent.getItemAtPosition(position) as String
            Toast.makeText(this,"Position: $position, value: $item",
                Toast.LENGTH_SHORT).show()

        }
        buttomAdd.setOnClickListener {

            var dialogview =layoutInflater.inflate(R.layout.dialog_add,null)
            var customDilalog= AlertDialog.Builder(this)
                .setView(dialogview)
                .show()

            var dButtonAdd= dialogview.findViewById<Button>(R.id.dailogbuttonRemove)

            var editTextDilaog=dialogview.findViewById<EditText>(R.id.editTextPersonUser)

            dButtonAdd.setOnClickListener {
                var name=editTextDilaog.text.toString()
                if (!name.isEmpty()){
                    user.add(name)
                    ulistAdapter.notifyDataSetChanged()
                    customDilalog.dismiss()
                }else {
                    Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_SHORT).show()
                }
            }


        }
        buttonDelete.setOnClickListener {
            var dialogView=layoutInflater.inflate(R.layout.dialog_delete,null)
            var customDialog=AlertDialog.Builder(this)
                .setView(dialogView)
                .show()
            var dialogButtomDelete =dialogView.findViewById<Button>(R.id.dialogbuttonDelete)

            dialogButtomDelete.setOnClickListener {
                var spinnerDialog=findViewById<Spinner>(R.id.dialogspinner)
                spinnerDialog.adapter=ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,user)
                spinnerDialog.onItemSelectedListener= object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        ulistAdapter.remove(spinnerDialog.selectedItem as String)
                        ulistAdapter.notifyDataSetChanged()
                        //user.removeAt(position)
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {

                    }

                }
            }
        }
    }
}