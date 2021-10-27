package com.example.week3_day4_tut1

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

        var ListView = findViewById<ListView>(R.id.ListView)
        var buttonAdd = findViewById<Button>(R.id.buttonAdd)
        var buttonDelete = findViewById<Button>(R.id.buttonDelete)

        // creat a list for user
        var users = mutableListOf<String>("Esra", "Sara", "Lama")

        // creat adapter for the users list
        // adapter connect list with listview

        var uListAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, users)
        // set the adapter
        ListView.adapter = uListAdapter


        ListView.setOnItemClickListener { parent, view, position, id ->

            var item = parent.getItemAtPosition(position) as String
            Toast.makeText(this, "Position $position , Value $item", Toast.LENGTH_SHORT).show()

            var intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("user", item)
            startActivity(intent)

        }

        buttonAdd.setOnClickListener {

            //users.add("Yara")
            //uListAdapter.notifyDataSetChanged()

            var dialogview = layoutInflater.inflate(R.layout.dialoglayout, null)
            var customDailog = AlertDialog.Builder(this)
                .setView(dialogview)
                .show()

            //cal dialog view
            var ButtonAddUser = dialogview.findViewById<Button>(R.id.ButtonDeleteUser)
            var editUserName = dialogview.findViewById<EditText>(R.id.editUserName)

            ButtonAddUser.setOnClickListener {
                var name = editUserName.text.toString()
                if (!name.isEmpty()) {
                    users.add(name)
                    uListAdapter.notifyDataSetChanged()
                    customDailog.dismiss()


                } else {
                    Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_SHORT).show()
                }
            }


        }
        buttonDelete.setOnClickListener {
            // users.removeLast()
            // uListAdapter.notifyDataSetChanged()

            var dialogview = layoutInflater.inflate(R.layout.dialoglayoutdisplyspinnerlist, null)
            var customDailog = AlertDialog.Builder(this)
                .setView(dialogview)
                .show()

            //cal dialog view
            var ButtonDeleteUser = dialogview.findViewById<Button>(R.id.ButtonDeleteUser)
            var spinnerList = dialogview.findViewById<Spinner>(R.id.spinnerList)


            spinnerList.adapter =
                ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, users)

           // var name = ""
            var pos = 0
            spinnerList?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

                override fun onItemSelected(
                    arg0: AdapterView<*>,
                    arg1: View,
                    position: Int,
                    id: Long
                ) { //name= arg0.getItemAtPosition(position).toString()
                    pos=position

                }

                override fun onNothingSelected(arg0: AdapterView<*>) {

                }
            }
            ButtonDeleteUser.setOnClickListener {

              // users.remove(name)
               users.removeAt(pos)
               uListAdapter.notifyDataSetChanged()
               customDailog.dismiss()
            }


        }

    }
}