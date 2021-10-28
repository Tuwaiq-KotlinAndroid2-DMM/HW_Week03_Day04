package com.login.testwithnora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listViewUsr= findViewById<ListView>(R.id.listViewUser)
        var btnadd= findViewById<Button>(R.id.buttonadd)
        var btnadddia= findViewById<Button>(R.id.buttonAddDia)
        var editTextuser= findViewById<EditText>(R.id.editTextName)
        var dialogView= findViewById<LinearLayout>(R.id.dialogView)
        var btnDelet= findViewById<Button>(R.id.btnDelete)

       var users =mutableListOf<String>("bdoor","lama","saja","nora","manar","mohanad","najah","sara")

        var ulistAdapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,users)
        listViewUsr.adapter=ulistAdapter

        listViewUsr.setOnItemClickListener { parent, view, position, id ->

            var item= parent.getItemAtPosition(position) as String

            Toast.makeText(this, "position: $position , value: $item",
                Toast.LENGTH_SHORT).show()
        }




        btnadd.setOnClickListener {
            btnadd.
        }






        btnadddia.setOnClickListener {
            var name= editTextuser.text.toString()
            if (!name.isEmpty()){
                users.add(name)
                ulistAdapter.notifyDataSetChanged()

            }else{
                Toast.makeText(this, "name cannot be Empty", Toast.LENGTH_SHORT).show()
            }


            btnDelet.setOnClickListener {
                var dialogView
            }


        }



        }
        }








