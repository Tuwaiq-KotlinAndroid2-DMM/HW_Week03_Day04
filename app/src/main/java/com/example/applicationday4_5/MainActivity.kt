package com.example.applicationday4_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.view.get

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var listViwe=findViewById<ListView>(R.id.listViwUser)
        var bbtnAdd=findViewById<Button>(R.id.buttonadd)
        var bbtnRemov=findViewById<Button>(R.id.buttonRemove)


        //create list for users
        var users= mutableListOf<String>("Salih","Mzon","Norah","Salih","Mzon","Norah")


        // create adapter for the user list
        var uListAdapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,users)
        //set the adapter
        listViwe.adapter=uListAdapter
        //*********
        listViwe.setOnItemClickListener { parent, view, position, id ->
            var item=parent.getItemAtPosition(position)as String
            Toast.makeText(this,"Position :$position , Value: $item",Toast.LENGTH_LONG).show()

            var intent = Intent(this,MainActivity2::class.java)
               intent.putExtra("Name",position)
                startActivity(intent)
        }

        bbtnAdd.setOnClickListener {
            /*users.add("Khalid")
            uListAdapter.notifyDataSetChanged()*/

            //inflate the layout
            var dialogviwe=layoutInflater.inflate(R.layout.layout_login,null)
            var  customdialog=AlertDialog.Builder(this)
                .setView(dialogviwe)
                .show()

            //call dialog viwes
            var dbtnadd= dialogviwe.findViewById<Button>(R.id.buttonAdd)
            var editText= dialogviwe.findViewById<EditText>(R.id.editTexttName)
            dbtnadd.setOnClickListener {
                var name=editText.text.toString()
                if (!name.isEmpty()){
                    users.add(name)
                uListAdapter.notifyDataSetChanged()
                customdialog.dismiss()

            }else{
                Toast.makeText(this,"Name cannot be empty",Toast.LENGTH_SHORT)
                    .show()
                }



        }
        bbtnRemov.setOnClickListener {
           users.removeLast()
            uListAdapter.notifyDataSetChanged()



           
                }



        }



    }}



