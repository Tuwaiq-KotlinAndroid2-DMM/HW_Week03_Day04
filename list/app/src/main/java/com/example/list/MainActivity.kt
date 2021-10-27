package com.example.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main )
        var listview = findViewById<ListView>(R.id.listview)
        var add = findViewById<Button>(R.id.add)
        var remove = findViewById<Button>(R.id.remove)
        var users = mutableListOf<String>(
            "emtnana",
            "ali",
            "wateen",
            "Ahmed",
        )
        var ulistAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, users)
        listview.adapter = ulistAdapter
      //  listview.setOnItemClickListener { parent, view, position, id ->
         //   var item = parent.getItemAtPosition(position) as String
           // Toast.makeText(this, "position: $position,value: $item", Toast.LENGTH_SHORT).show()
         //   var intent = Intent(this, MainActivity2::class.java)
         //   intent.putExtra("item", item)
          //  startActivity(intent)

            //  add.setOnClickListener {
            // users.add("Khaled")
            //    ulistAdapter.notifyDataSetChanged()
         //   var dialogview = layoutInflater.inflate(R.layout.layout, null)
          //  var customDialog = AlertDialog.Builder(this)
             //   .setView(dialogview)
            //    .show()


            //    remove.setOnClickListener {
            //     users.removeLast()
            //       ulistAdapter.notifyDataSetChanged()
            //      }

          //  var button2 = dialogview.findViewById<Button>(R.id.button2)
         //   var editTextTextEmailAddress =
         //       dialogview.findViewById<EditText>(R.id.editTextTextEmailAddress)
        //    button2.setOnClickListener {
        //        var name = editTextTextEmailAddress.text.toString()
          //      if (!name.isEmpty()) {
                //    users.add(name)
                  //  ulistAdapter.notifyDataSetChanged()
                  //  customDialog.dismiss()
             //   } else {
                   // Toast.makeText(this, "name cannot be empty", Toast.LENGTH_SHORT).show()
               // }
          //  }

            remove.setOnClickListener {

                var dialogview = layoutInflater.inflate(R.layout.remove, null)
                var customDialog = AlertDialog.Builder(this)
                    .setView(dialogview)
                    .show()
                var button2 = dialogview.findViewById<Button>(R.id.button2)
                var spinner = dialogview.findViewById<Spinner>(R.id.spinner)
                spinner.adapter = ulistAdapter
                button2.setOnClickListener {
                    var select = spinner.selectedItem
                    users.remove(select)
                    ulistAdapter.notifyDataSetChanged()
                    customDialog.dismiss()
                }
            }

        }
    }




