package com.example.week3day4

import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var listView = findViewById<ListView>(R.id.listviwe)
        var button = findViewById<Button>(R.id.buttonAdd)
        //var btndelet = findViewById<Button>(R.id.buttonAdd)
        var users = mutableListOf<String>(
            "Tulip",
            "Ali",
            "Ahmad",
            "Sara"

        )

        var listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, users)
        listView.adapter = listAdapter

        // item click listener
        listView.setOnItemClickListener { parent, view, position, id ->
            var item = parent.getItemAtPosition(position) as String
            Toast.makeText(this, "positin:$,value: $item", Toast.LENGTH_LONG).show()

            //  var intent = Intent(this, Username::class.java)
            //  intent.putExtra("name", item)
            //  startActivity(intent)


            // btnAdd.setOnClickListener{
            //   users.add("Ali")
            //   listAdapter.notifyDataSetChanged()
            // }
            //  btndelet.setOnClickListener{
            //       users.removeLast()
            //       listAdapter.notifyDataSetChanged()
            //    }


        }

        button.setOnClickListener {
            var dialogView = layoutInflater.inflate(R.layout.dialog_custom_layout, null)
            var customDialog = AlertDialog.Builder(this)
                .setView(dialogView)
                .show()
            //var button3 = dialogView.findViewById<Button>(R.id.button3)
            var dETextName = dialogView.findViewById<EditText>(R.id.dETextName)
            var btnspinnar = button.findViewById<Button>(R.id.btnspinnar)
            var spinnername = dialogView.findViewById<Spinner>(R.id.spinnarName)
            spinnername.adapter = ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item, users
            )
            dialogView.setOnClickListener {
                spinnername.onItemSelectedListener = object :
                    AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(p0: AdapterView<*>?, ?, p2: Int, p3: Long) {
                        listAdapter.remove(spinnername.getSelectedItem() as String)
                        listAdapter.notifyDataSetChanged()
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {


                    }
                }
            }
        }
    }
}


//            var name = dETextName.text.toString()
//            if (!name.isEmpty()) {
//                users.add(name)
//                listAdapter.notifyDataSetChanged()
//                customDialog.dismiss()
//            } else {
//                Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_SHORT).show()
//            }
