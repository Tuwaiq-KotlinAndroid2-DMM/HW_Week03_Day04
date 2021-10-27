package com.tuwaq.listveiew2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listview = findViewById<ListView>(R.id.listviewUsers)
        var btnAdd = findViewById<Button>(R.id.buttonadd)
        var btnremove = findViewById<Button>(R.id.buttonadd)
        var users = mutableListOf<String>("ali","sara","hamad")



        var uListAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,users)

        listview.adapter=uListAdapter


        listview.setOnItemClickListener { parent, view, position, id ->

            var item = parent.getItemAtPosition(position) as String
            Toast.makeText(this, "position: $position , value: $item",
                Toast.LENGTH_SHORT)
                .show()

            var intent = Intent(this,MainActivity2::class.java)
            intent.putExtra("name",item)

            startActivity(intent)

        }

     btnAdd.setOnClickListener {
         users.add("khaled")

         uListAdapter.notifyDataSetChanged()


         var dialgview = layoutInflater.inflate(R.layout.costumdaialog,null)

         var customDialog = AlertDialog.Builder(this)
             .setView(dialgview)
             .show()

         var dbuttonAdd = dialgview.findViewById<Button>(R.id.buttonadd)
         var editTextDialog = dialgview.findViewById<EditText>(R.id.editTextAdd)

            dbuttonAdd.setOnClickListener {
                var name = editTextDialog.text.toString()
                if (!name.isEmpty()) {
                    users.add(name)
                    uListAdapter.notifyDataSetChanged()
                    customDialog.dismiss()
                }else{
                    Toast.makeText(this,"name connot be eampty", Toast.LENGTH_SHORT)
                        .show()
                }

            }
     }
    btnremove.setOnClickListener {
       users.removeLast()
        uListAdapter.notifyDataSetChanged()
    }

    }
}