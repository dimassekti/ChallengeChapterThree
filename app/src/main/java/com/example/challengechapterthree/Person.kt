package com.example.challengechapterthree

import java.io.Serializable

data class Person(val age : Int, val address : String, val job : String) : Serializable


//Parsing data menggunakan Serializable