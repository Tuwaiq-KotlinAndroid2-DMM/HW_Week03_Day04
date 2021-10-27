package com.example.week3_day4_practice2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listview = findViewById<ListView>(R.id.listview)
        var add = findViewById<Button>(R.id.add)
        var remove = findViewById<Button>(R.id.remove)

//        var remove = findViewById<Button>(R.id.remove)
        // create list for users
        var users = mutableListOf<String>(
            "Dalia", "Tala", "Nora", "Abdullah", "Ibrahim", "Khalid"
        )
        //create adapter for the users list
        var uListAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, users)

        //set the adapter
        listview.adapter = uListAdapter
/*
        listViewU.setOnItemClickListener { parent, view, position, id ->
            var item =
                parent.getItemAtPosition(position) as String//we only want the string//parent mean the item itself //view //position edit the position of the page
            Toast.makeText(this,
                "Position: $position , View: $item", Toast.LENGTH_LONG).show()




            var intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("name",item)
            startActivity(intent)


        }


        //
        btnAdd.setOnClickListener {
            //add to the list
           /* users.add("Lama")

            //notify the adapter
            uListAdapter.notifyDataSetChanged()

            */
            //inflate the layout
            var dialgView = layoutInflater.inflate(R.layout.lay1,null)

            //create custom dialog
            var cutomDialog = AlertDialog.Builder(this)
                .setView(dialgView)
                .show()

            //call dialog view
            var dButtonAdd = dialgView.findViewById<Button>(R.id.btnDelete)
            var editTextDialog = dialgView.findViewById<EditText>(R.id.dialgEText)

            dButtonAdd.setOnClickListener{
                var name = editTextDialog.text.toString()
                if (!name.isEmpty()){
                    users.add(name)
                    uListAdapter.notifyDataSetChanged()
                    cutomDialog.dismiss()

                }
                else{
                    Toast.makeText(this,"Name cannot be empty", Toast.LENGTH_LONG).show()
                }
            }

        }
//        btnDelete.setOnClickListener {
//            //add to the list
//
//
//            //notify the adapter
//
//        }



        /*
        btnDelete.setOnClickListener {
            //add to the list
            users.remove("Lama")

            //notify the adapter
            uListAdapter.notifyDataSetChanged()
        }

         */






 */

        /****************************************************/
        remove.setOnClickListener {

                var dialogView = layoutInflater.inflate(R.layout.remove, null)
                var customDialog = AlertDialog.Builder(this)
                    .setView(dialogView)
                    .show()
                var button2 = dialogView.findViewById<Button>(R.id.button2)
                var spinner = dialogView.findViewById<Spinner>(R.id.spinner)

                spinner.adapter = uListAdapter
            button2.setOnClickListener {
                    var select = spinner.selectedItem
                    users.remove(select)
                    uListAdapter.notifyDataSetChanged()
                    customDialog.dismiss()

            }
        }
        /* var btnRemove = layoutInflater.inflate(R.layout.dialog_layout_remove,null)
         var customDialog = AlertDialog.Builder(this).setView()
        btnRemove.setOnClickListener
         btnDelete.setOnClickListener {
             //add to the list
             users.remove()

             //notify the adapter

         }

         */

    }
}