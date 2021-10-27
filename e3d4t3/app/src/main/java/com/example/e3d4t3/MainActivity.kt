package com.example.e3d4t3

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


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
        var ButtonRemove = findViewById<Button>(R.id.ButtonRemove)
        ButtonRemove.setOnClickListener {
            var dialog2 = layoutInflater.inflate(R.layout.dialog2, null)
            var customDailog2 = AlertDialog.Builder(this)
                .setView(dialog2)
                .show()

            var dilogremove = dialog2.findViewById<Button>(R.id.dilogremove)
            var spinnername = dialog2.findViewById<Spinner>(R.id.spinnername)
            spinnername.adapter = ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item, usres
            )

            dilogremove.setOnClickListener {
                spinnername.onItemSelectedListener = object :
                    AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                        uListAdapter.remove(spinnername.getSelectedItem() as String)
                        uListAdapter.notifyDataSetChanged()
                        customDailog2.dismiss()
                    }
                    override fun onNothingSelected(p0: AdapterView<*>?) {
                    }

                }
            }

        }
    }
}







