package com.example.hw_week3_day4_solution

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var listViewU = findViewById<ListView>(R.id.ListView)
        var usres = mutableListOf<String>(
            "Dalia",
            "Tala",
            "Nora",
            "Abdullah",
            "Khalid",
            "Ibrahim"
        )
        var uListAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, usres)
        listViewU.adapter = uListAdapter
        var ButtonRemove = findViewById<Button>(R.id.ButtonRemove)
        var customDailog = AlertDialog.Builder(this)
        ButtonRemove.setOnClickListener {
            var dialog2 = layoutInflater.inflate(R.layout.dialog2, null)
            var customDailog2 = AlertDialog.Builder(this)
                .setView(dialog2)
                .show()

            var dilogremove = dialog2.findViewById<Button>(R.id.dilogremove)
            var spinner = dialog2.findViewById<Spinner>(R.id.spinner)
            spinner.adapter = ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item, usres
            )
            dilogremove.setOnClickListener {
                spinner.onItemSelectedListener = object :
                    AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                        uListAdapter.remove(spinner.getSelectedItem() as String)
                        uListAdapter.notifyDataSetChanged()
                    }
                    override fun onNothingSelected(p0: AdapterView<*>?) {
                    }

                }

                var dialogView = layoutInflater.inflate(R.layout.dialog2, null)
                var customDailog = AlertDialog.Builder(this)
                    .setView(dialogView)
                    .show()
                var dilogremove = dialogView.findViewById<Button>(R.id.dilogremove)
                var spinner = dialogView.findViewById<Spinner>(R.id.spinner)

                spinner.adapter = uListAdapter

                dilogremove.setOnClickListener {
                    var select = spinner.selectedItem
                    usres.remove(select)
                    uListAdapter.notifyDataSetChanged()
                    customDailog.dismiss()

                }

            }

        }
    }
}