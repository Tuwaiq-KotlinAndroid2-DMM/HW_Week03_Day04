package com.alidevs.listview

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.view.View.*

import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val usersListView = findViewById<ListView>(R.id.usersListView)
		val addButton = findViewById<Button>(R.id.addButton)
		val deleteButton = findViewById<Button>(R.id.deleteButton)

		val arrayOfUsers = mutableListOf(
			User("Ali", 22, "Developer", 22000),
			User("Najah", 27, "Developer", 27000),
			User("Khalid", 25, "Truck Driver", 1835),
			User("Ghzlan", 24, "manager", 24000),
			User("Faris", 5, "CEO", 16380),
			User("Noura", 29, "Teacher", 264815)
		)

		val usersListAdapter = object : ArrayAdapter<Any?>(this,
			android.R.layout.simple_list_item_2,
			android.R.id.text1,
			arrayOfUsers.toTypedArray()) {
			override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
				val view = super.getView(position, convertView, parent)
				val nameTextView = view.findViewById<TextView>(android.R.id.text1)
				val jobTextView = view.findViewById<TextView>(android.R.id.text2)
				nameTextView.text = arrayOfUsers[position].name
				jobTextView.text = arrayOfUsers[position].job
				return view
			}
		}

		val myBaseAdapter = MyAdapter(arrayOfUsers, this)
		usersListView.adapter = myBaseAdapter

		usersListView.setOnItemClickListener { adapterView, view, pos, id ->
			val intent = Intent(this, UserInformation::class.java)
			intent.putExtra("user", arrayOfUsers[pos])
			startActivity(intent)
		}

		addButton.setOnClickListener {
			val dialogLayout = layoutInflater.inflate(R.layout.custom_add_dialog, null)
			val customDialog = AlertDialog.Builder(this)
				.setView(dialogLayout)
				.show()

			val addUserTextField = dialogLayout.findViewById<EditText>(R.id.usernameEditText)
			val addUserButton = dialogLayout.findViewById<Button>(R.id.addUserButton)

			addUserButton.setOnClickListener {
				val newUser = User(addUserTextField.text.toString(), 0, "", 0)
				arrayOfUsers.add(newUser)
				myBaseAdapter.notifyDataSetChanged()
				Toast.makeText(this, "${addUserTextField.text} has been added", Toast.LENGTH_SHORT).show()
				customDialog.dismiss()
			}

		}

		deleteButton.setOnClickListener {
			val dialogLayout = layoutInflater.inflate(R.layout.custom_remove_dialog, null)
			val usersSpinner = dialogLayout.findViewById<Spinner>(R.id.removeUsersSpinner)
			val removeButton = dialogLayout.findViewById<Button>(R.id.removeUsersDialogButton)
			val customDialog = AlertDialog.Builder(this)
				.setView(dialogLayout)
				.show()
			val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayOfUsers)
			var userToRemove: User? = null

			usersSpinner.adapter = arrayAdapter

			usersSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
				override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
					val selectedObject = usersSpinner.selectedItem as User
					userToRemove = selectedObject
				}

				override fun onNothingSelected(p0: AdapterView<*>?) {
					userToRemove = null
				}
			}

			removeButton.setOnClickListener {
				if (userToRemove != null) {
					arrayOfUsers.remove(userToRemove)
					myBaseAdapter.notifyDataSetChanged()
					Toast.makeText(this, "Removed user ${userToRemove!!.name}", Toast.LENGTH_SHORT).show()
					customDialog.dismiss()
				}
			}
		}

	}
}

class MyAdapter(var usersList: List<User>, var activity: Activity) : BaseAdapter() {

	override fun getItem(position: Int): Any {
		return usersList[position]
	}

	override fun getItemId(position: Int): Long {
		return position.toLong()
	}

	override fun getCount(): Int {
		return usersList.size
	}

	override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
		val view: View = inflate(activity, R.layout.row, null)

		val userNameTextView = view.findViewById<TextView>(R.id.userNameTextView)
		val userJobTextView = view.findViewById<TextView>(R.id.userJobTextView)
		val userSalaryTextView = view.findViewById<TextView>(R.id.rowSalaryTextView)

		userNameTextView.text = usersList[position].name
		userJobTextView.text = usersList[position].job
		userSalaryTextView.text = "$${usersList[position].salary}"

		view.minimumHeight = 40

		return view
	}

}