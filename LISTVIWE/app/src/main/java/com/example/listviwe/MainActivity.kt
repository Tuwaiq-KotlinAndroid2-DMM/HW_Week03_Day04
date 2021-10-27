package com.example.listviwe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listvieu = findViewById<ListView>(R.id.listvieu)
        var btnAdd = findViewById<Button>(R.id.btnAdd)


        var users = mutableListOf<String>(
            "ali",
            "turki",
            "mohamad",
            "fahad",


            )
        var ulistAbapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, users)
        listvieu.adapter = ulistAbapter
        listvieu.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(
                this, "position:$position value",
                Toast.LENGTH_SHORT
            ).show()


            var i = Intent(this, MainActivity2::class.java)
            i.putExtra("user", users[position])
            startActivity(i)
        }


        btnAdd.setOnClickListener {
            var dilog = layoutInflater.inflate(R.layout.layout, null)


            var customDialog = AlertDialog.Builder(this)
                .setView(dilog)
                .show()

            var dButtonAdd = dilog.findViewById<Button>(R.id.dialogButtonDelete)
            var editTextDilog = dilog.findViewById<EditText>(R.id.dialogEditTixt)
            dButtonAdd.setOnClickListener {
                var name = editTextDilog.text.toString()
                if (!name.isEmpty()) {
                    users.add(name)
                    ulistAbapter.notifyDataSetChanged()
                    customDialog.dismiss()

                } else {
                    Toast.makeText(this, "name cannot be empty", Toast.LENGTH_SHORT)
                }
            }



        }
        var btnDelete = findViewById<Button>(R.id.btnDelete)
        btnDelete.setOnClickListener {
            var dilog = layoutInflater.inflate(R.layout.delet, null)

            var customDialog = AlertDialog.Builder(this)
                .setView(dilog)
                .show()

            var spinner = dilog.findViewById<Spinner>(R.id.spinner)
            var spinnerAdapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,users)

            spinner.adapter = spinnerAdapter

            var dialogButtonDelete = dilog.findViewById<Button>(R.id.dialogButtonDelete)


            dialogButtonDelete.setOnClickListener {

                var removedName = spinner.selectedItem.toString()
                users.remove(removedName)
                ulistAbapter.notifyDataSetChanged()
                customDialog.cancel()


            }


        }
    }
}
