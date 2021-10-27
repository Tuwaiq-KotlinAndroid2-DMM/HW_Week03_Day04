package com.tuwaq.spenneronlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog


/**
         *  ListView
         */

        class MainActivity : AppCompatActivity() {
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)

                var listViewU = findViewById<ListView>(R.id.listviewUsers)
                var btnRemove = findViewById<Button>(R.id.buttonaR)

                // create list for users
                var users = mutableListOf(
                    "Ali",
                    "Mohammad",
                    "Sara",
                    "hamad",
                    "Ahmad",
                    "khaled"
                )

                // create adapter for the users list
                var uListAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,
                    users)


                // set the adapter
                listViewU.adapter = uListAdapter

                listViewU.setOnItemClickListener { parent, view, position, id ->
                    var item = parent.getItemAtPosition(position) as String
                    Toast.makeText(this, "Postion: $position, Value: $item",
                        Toast.LENGTH_LONG).show()
                }

                btnRemove.setOnClickListener {

                    // inflate the layout
                    var dialgView = layoutInflater.inflate(R.layout.removedaialog,null)

                    // create custom dialog
                    var customDialog = AlertDialog.Builder(this)
                        .setView(dialgView)
                        .show()

                    // call dialog`s views
                    var dButtonRemove = dialgView.findViewById<Button>(R.id.buttonRemove)
                    var spinnerList = dialgView.findViewById<Spinner>(R.id.spinnerList)
                    spinnerList.adapter = ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_spinner_item, users
                    )
                    dButtonRemove.setOnClickListener {
                        spinnerList.onItemSelectedListener = object :
                            AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int,
                                                        p3: Long) {
                                uListAdapter.remove(spinnerList.getSelectedItem() as String)
                                uListAdapter.notifyDataSetChanged()
                            }
                            override fun onNothingSelected(p0: AdapterView<*>?) {
                            }

                        }
                    }

                }
            }
}
