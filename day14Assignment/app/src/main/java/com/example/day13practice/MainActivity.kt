package com.example.day13practice

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SearchView
import com.google.android.material.textfield.TextInputLayout
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout


class MainActivity : AppCompatActivity() {

    //list of items
    var listItems = ArrayList<String>()

    //adaptor
    var adapter: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //component
        var searchView = findViewById<androidx.appcompat.widget.SearchView>(R.id.searchViewCountry)
        var listView = findViewById<ListView>(R.id.ListViewItems)
        var addBtn = findViewById<Button>(R.id.buttonAdd)
        var removeBtn = findViewById<Button>(R.id.buttonRemoveItem)

        adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems)
        listView.adapter = adapter

        searchFromListView(searchView)

        listView.setOnItemClickListener { parent, view, position, id ->
            showItemInfo(parent, position)
        }

        addBtn.setOnClickListener {onAddItem()}

        removeBtn.setOnClickListener {onDeleteItem()}
    }

    private fun onDeleteItem() {
        val customAlertDialog = AlertDialog.Builder(this).create()
        customAlertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val view = layoutInflater.inflate(R.layout.spinner_layout,null)

        var spinnerInput = view.findViewById<Spinner>(R.id.spinnerListItem)
        var btnDeleteItem = view.findViewById<Button>(R.id.buttonDeleteItem)

        var spinnerAdapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, listItems)

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        spinnerInput.adapter = spinnerAdapter

        customAlertDialog.setView(view)

        btnDeleteItem.setOnClickListener {
            var selectedItemPosition = spinnerInput.selectedItemPosition
            adapter?.remove(adapter?.getItem(selectedItemPosition))
            adapter?.notifyDataSetChanged()
        }

        customAlertDialog.setCanceledOnTouchOutside(true)
        customAlertDialog.show()
    }

    private fun showItemInfo(parent: AdapterView<*>, position: Int) {
        var item = parent.getItemAtPosition(position).toString()
        var intent = Intent(this, MainActivityUser::class.java)
        intent.putExtra("name", item)
        startActivity(intent)
    }

    private fun onAddItem() {
        val customAlertDialog = AlertDialog.Builder(this).create()
        customAlertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val view = layoutInflater.inflate(R.layout.custom_dialog_layout,null)

        var editTextInput = view.findViewById<TextInputLayout>(R.id.editTextAddItem)
        var btnAddItem = view.findViewById<Button>(R.id.buttonAddItem)

        customAlertDialog.setView(view)

        editTextInput.editText?.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP){
                btnAddItem.performClick()
                true
            }
            false
        }

        btnAddItem.setOnClickListener {addItemToListView(editTextInput)}

        customAlertDialog.setCanceledOnTouchOutside(true)
        customAlertDialog.show()
    }

    private fun addItemToListView(editTextInput: TextInputLayout) {
        var text = editTextInput.editText?.text.toString()
        if (!text.isNullOrEmpty() && !text.equals("\n")){
            listItems.add(text)
            adapter!!.notifyDataSetChanged()
            editTextInput.editText?.text?.clear()
            editTextInput.error = ""
        } else {
            editTextInput.error = "the text cannot be empty"
        }
    }

    private fun searchFromListView(searchView: SearchView) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (listItems.contains(query)) {
                    adapter!!.filter.filter(query)
                } else {
                    Toast.makeText(this@MainActivity, "No Match found", Toast.LENGTH_LONG).show()
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter!!.filter.filter(newText)
                return true
            }

        })
    }

    private fun removeLastItem() {
        var count = adapter!!.count
        if (count != 0){
            adapter?.remove(adapter?.getItem(count - 1))
            adapter?.notifyDataSetChanged()
        }
    }
}
