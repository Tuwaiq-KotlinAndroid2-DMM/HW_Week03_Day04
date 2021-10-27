package com.example.listview2

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


        var userListView= findViewById<ListView>(R.id.listViewUsers)
        var addButton = findViewById<Button>(R.id.buttonDialogAdd)
        var removeButton = findViewById<Button>(R.id.buttonRemove)


        //create list for users
        var users= mutableListOf<String>(
            "Fatima","Zainab","Ghufran","Ali")


        //create addapter for user list
        var uListAdappter=
            ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,users)

        userListView.adapter=uListAdappter


        userListView.setOnItemClickListener { parent, view, position, id ->
            var item = parent.getItemAtPosition(position) as String
            var intent = Intent(this,userInfo::class.java)
            intent.putExtra("name",item)
            startActivity(intent)
            //Toast.makeText(this,"position: $position, Value:$item",Toast.LENGTH_LONG).show()
        }



        addButton.setOnClickListener {

            var dialgView= layoutInflater.inflate(R.layout.dialog_custom,null)
            var customDialog = AlertDialog.Builder(this)
                .setView(dialgView)
                .show()

            var dButtonAdd= dialgView.findViewById<Button>(R.id.buttonDialogAdd)
            var dEditText= dialgView.findViewById<EditText>(R.id.EditTextUser)

            dButtonAdd.setOnClickListener {
                var name= dEditText.getText().toString()
                if(!name.isEmpty()){
                    users.add(name)
                    uListAdappter.notifyDataSetChanged()
                    customDialog.dismiss()
                 }else
                {
                    Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_SHORT).show()
                }


            }

        }

        removeButton.setOnClickListener {

            var dialgView= layoutInflater.inflate(R.layout.remove_dialog,null)
            var deleteDialog = AlertDialog.Builder(this)
                .setView(dialgView)
                .show()

            var dRemovebtn= dialgView.findViewById<Button>(R.id.buttonDialogRemove)
            var userSpinner= dialgView.findViewById<Spinner>(R.id.spinnerUser)


            userSpinner.adapter=uListAdappter

            userSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {


                override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {

                    dRemovebtn.setOnClickListener {
                        users.removeAt(pos)
                        uListAdappter.notifyDataSetChanged()
                        deleteDialog.dismiss()

                    }

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }

        }

    }

}