package com.example.a23

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var listViewU = findViewById<ListView>(R.id.listViewUserss)
        var btnAdd = findViewById<Button>(R.id.button10)

        var users = mutableListOf(
            "Ali",
            "Mohammad",
            "Sara","Amar","Maitham","Meqdad"
        )

        var uListAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,users)


        listViewU.adapter = uListAdapter

        listViewU.setOnItemClickListener { parent, view, position, id ->
            var item = parent.getItemAtPosition(position) as String
            Toast.makeText(this, "Postion: $position, Value: $item",
                Toast.LENGTH_LONG).show()
        }

        btnAdd.setOnClickListener {

            var dialgView = layoutInflater.inflate(R.layout.dialog_custom_layout,null)

            var customDialog = AlertDialog.Builder(this)
                .setView(dialgView)
                .show()

            var dButtonAdd = dialgView.findViewById<Button>(R.id.dialogButtonAdd)
            var editTextDialog = dialgView.findViewById<EditText>(R.id.dialogEText)

            dButtonAdd.setOnClickListener {
                var name = editTextDialog.text.toString()
                if (!name.isEmpty()){
                    users.add(name)
                    uListAdapter.notifyDataSetChanged()
                    customDialog.dismiss()
                } else {
                    Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_SHORT).show()
                }
            }

        }

    }
}


    }
}