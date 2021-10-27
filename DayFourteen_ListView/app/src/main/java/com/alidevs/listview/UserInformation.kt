package com.alidevs.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class UserInformation : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_user_information)

		val nameTextView = findViewById<TextView>(R.id.nameTextView)
		val ageTextView = findViewById<TextView>(R.id.ageTextView)
		val jobTextView = findViewById<TextView>(R.id.jobTextView)
		val salaryTextView = findViewById<TextView>(R.id.salaryTextView)

		val user = intent.getSerializableExtra("user") as User

		nameTextView.text = user.name
		ageTextView.text = user.age.toString()
		jobTextView.text = user.job
		salaryTextView.text = user.salary.toString()
	}
}