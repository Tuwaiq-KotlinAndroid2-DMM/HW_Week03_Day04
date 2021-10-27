package com.alidevs.listview

import java.io.Serializable

class User (var name: String, var age: Int, var job: String, var salary: Int): Serializable {
	override fun toString() = name
}