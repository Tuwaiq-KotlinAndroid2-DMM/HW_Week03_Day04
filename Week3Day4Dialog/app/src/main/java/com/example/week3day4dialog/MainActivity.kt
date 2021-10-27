package com.example.week3day4dialog

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

        var listViewU=findViewById<ListView>(R.id.ListViewUser)
        var BtnAdd= findViewById<Button>(R.id.buttonAdd)
        var BtnRemove=findViewById<Button>(R.id.buttonRemove)
        var nameSpinner=findViewById<Spinner>(R.id.spinnerNames)


            // create list for users
        var users= mutableListOf<String>("Ali", " Mohammed","Sara")

        // create adapter to connect between the list and the lisView of the android
        // create adapter for the user list

        var uListAdapterr=ArrayAdapter(this,android.R.layout.simple_list_item_1,users)

        // set the adapter
        listViewU.adapter=uListAdapterr



        listViewU.setOnItemClickListener { parent, view, position, id ->
           var item =parent.getItemAtPosition(position) as String // casting (as)because we want the string
        // the item not the position
          //  Toast.makeText(this, "Position: $position, Value: $item,", Toast.LENGTH_SHORT).show()

            var ItemIntent=Intent(this,MainActivity2::class.java)
            ItemIntent.putExtra("Name",item)
            startActivity(ItemIntent)
        }

       // var adding= userAdd.text
        BtnAdd.setOnClickListener {
            // create custom layout
            var dialogview=layoutInflater.inflate(R.layout.custome_dialog,null)
            var customDialog=AlertDialog.Builder(this)
                .setView(dialogview)
                .show()

            //call dialog's view

            var dButtonAdd=dialogview.findViewById<Button>(R.id.buttonDialogAdd)
            var editTextDialog =dialogview.findViewById<EditText>(R.id.dialogEText)

            dButtonAdd.setOnClickListener {
                var name=editTextDialog.text.toString()
                if (!name.isEmpty()){
                    users.add(name)
                    uListAdapterr.notifyDataSetChanged()
                    customDialog.dismiss()
                }
            }
         //   users.add("Khalid")
           // uListAdapterr.notifyDataSetChanged()
        }



        BtnRemove.setOnClickListener {
            var dialogView=layoutInflater.inflate(R.layout.spinnerdialog,null)
            var removeDialog=AlertDialog.Builder(this)
                .setView(dialogView)
                .show()

            var dbuttonRemove=removeDialog.findViewById<Button>(R.id.buttonDialogRemove)
            var nameSpinner=removeDialog.findViewById<Spinner>(R.id.spinnerNames)



            var Spinneradapter= ArrayAdapter<String>(
                this,
               android.R.layout.simple_spinner_item,users)
            nameSpinner?.adapter=Spinneradapter //تربطيهم هنا

            dbuttonRemove?.setOnClickListener {
                    var item =nameSpinner?.selectedItem
                    users.remove(item)
                    uListAdapterr.notifyDataSetChanged()
                    removeDialog.dismiss()
                }
                    


                }


        }




    }





