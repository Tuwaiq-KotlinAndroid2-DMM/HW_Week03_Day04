package com.example.w3d4t2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var listViewU = findViewById<ListView>(R.id.listview)
        var usres = mutableListOf<String>(
            "Ali",
            "Mohammed",
            "Sara",
            "Sara"
        )
        var uListAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, usres)
        listViewU.adapter = uListAdapter
        listViewU.setOnItemClickListener { parent, view, position, id ->
            var item = parent.getItemAtPosition(position) as String
            Toast.makeText(this, "Position: $position , Value: $item", Toast.LENGTH_LONG).show()
            var intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("name", item)
            startActivity(intent)
        }
        var btnadd = findViewById<Button>(R.id.btnadd)
        btnadd.setOnClickListener {
            usres.add("Khairiah")
            uListAdapter.notifyDataSetChanged()
        }
        var btnadd2 = findViewById<Button>(R.id.btnadd2)
        var editTextTextPersonName = findViewById<EditText>(R.id.edtname)
        btnadd2.setOnClickListener {
            usres.add(editTextTextPersonName.text.toString())
            uListAdapter.notifyDataSetChanged()
        }

        var btnadd4 = findViewById<Button>(R.id.btnadd4)
        btnadd4.setOnClickListener {
            var dialog = layoutInflater.inflate(R.layout.dialog, null)
            var customDailog = AlertDialog.Builder(this)
                .setView(dialog)
                .show()
            var dilogadd = dialog.findViewById<Button>(R.id.dilogremove)
            var edtname = dialog.findViewById<EditText>(R.id.edtname)
            dilogadd.setOnClickListener {
                var name = edtname.text.toString()
                if (!name.isEmpty()) {
                    usres.add(name)
                    uListAdapter.notifyDataSetChanged()
                    customDailog.dismiss()

                } else {
                    Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}





