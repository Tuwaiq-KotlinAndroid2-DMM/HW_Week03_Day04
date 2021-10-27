package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.*
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        var listViewU = findViewById<ListView>(R.id.ListViewUsers)
        var buttonAdd = findViewById<Button>(R.id.buttonAdd)
        var buttonRemove = findViewById<Button>(R.id.ButtonRemove)
        //create lits for users
        var users = mutableListOf<String>(
            "Ali",
            "Ahmad",
            "Khalid"
        )
        //crreate adapter for the users
        var uListAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,users)
        //set the adapter
        listViewU.adapter = uListAdapter
        
        listViewU.setOnItemClickListener { parent, view, position, id -> 
            var item= parent.getItemAtPosition(position) as String
            Toast.makeText(this,"Position $position, Value: $item", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("Name: ",item)
            intent.putExtra("the index",position)
            startActivity(intent)
            
            buttonAdd.setOnClickListener{
                //add to the list
               // users.add("Ali")
                //notify the adapter about the change
               // uListAdapter.notifyDataSetChanged()
                var dialogView = layoutInflater.inflate(R.layout.layoutdesign,null)
                var customDialog = AlertDialog.Builder(this)
                    .setView(dialogView)
                    .show()
                var dButtonAdd = dialogView.findViewById<Button>(R.id.button)
                var editTextDialog =dialogView.findViewById<EditText>(R.id.design) //design is the name of calss that i created to custom the textField
                
                dButtonAdd.setOnClickListener{
                    var name = editTextDialog.text.toString()
                    if(!name.isEmpty()){
                        users.add(name)
                        uListAdapter.notifyDataSetChanged()
                        customDialog.dismiss()
                        
                    }else{
                        Toast.makeText(this,"Name cannot be empty", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            buttonRemove.setOnClickListener{
                //Remove to the list
               // users.removeLastOrNull()
                //notify the adapter about the change
              //  uListAdapter.notifyDataSetChanged()
                var dialogView = layoutInflater.inflate(R.layout.layoutdesign,null)
                var customDialog = AlertDialog.Builder(this)
                    .setView(dialogView)
                    .show()
                var dButtonRemove = dialogView.findViewById<Button>(R.id.button)
                var editTextDialog =dialogView.findViewById<EditText>(R.id.design) //design is the name of calss that i created to custom the textField

                dButtonRemove.setOnClickListener{
                    var name = editTextDialog.text.toString()
                    if(!name.isEmpty()){
                        users.add(name)
                        uListAdapter.notifyDataSetChanged()
                        customDialog.dismiss()

                    }else{
                        Toast.makeText(this,"Name cannot be empty", Toast.LENGTH_SHORT).show()
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
    }
