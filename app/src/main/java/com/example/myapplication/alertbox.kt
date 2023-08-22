package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog





class alertbox() : AppCompatActivity() {
    lateinit var tvuser : TextView
    lateinit var tvpass : TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alertbox)


        val alert12 = findViewById<Button>(R.id.button)
        alert12.setOnClickListener {

            val builder = AlertDialog.Builder(this)

            builder.setMessage("Do you want to exit ?")

            builder.setTitle("Alert !")

            builder.setCancelable(false)

            builder.setPositiveButton("Yes") { dialog, which ->
                finish()
            }

            builder.setNegativeButton("No") { dialog, which ->
                dialog.cancel()
            }

            val alertDialog = builder.create()
            alertDialog.show()
        }

        val listView = findViewById<ListView>(R.id.ListView)
        val listOfItems = listOf("Thor", "Ironman", "Spiderman", "Loki", "Hulk", "Thanos", "Doctor strange", "Captain America", "Batman", "Flash", "Ant-Man", "Moon-knight", "I Am Groot","Star-lord", "Gamora", "Nabula")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listOfItems)
        listView.setAdapter(adapter)


    }

    }







