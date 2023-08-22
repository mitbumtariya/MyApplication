package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.UserHandle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.auth.User
import com.google.firebase.ktx.Firebase

class MainActivity2 : AppCompatActivity() {
//    private lateinit var binding : ActivityMainBinding
    private lateinit var database : FirebaseDatabase
    private lateinit var userrefrence : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)

//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)

        database = FirebaseDatabase.getInstance()
        userrefrence = database.reference.child("UserTable")
        val radioButtonMale: RadioButton = findViewById(R.id.radioButton)
        val radioButtonFemale : RadioButton = findViewById(R.id.radioButton2)

        radioButtonMale.setOnClickListener{
            Toast.makeText(applicationContext, "Male selected", Toast.LENGTH_SHORT).show()
        }

        radioButtonFemale.setOnClickListener{
            Toast.makeText(applicationContext, "FeMale selected", Toast.LENGTH_SHORT).show()
        }

        val textview2 = findViewById<TextView>(R.id.ilogin)
        textview2.setOnClickListener{
            val intent2 = Intent(this, MainActivity::class.java)
            startActivity(intent2)
        }

        val submit = findViewById<Button>(R.id.signup12)
        submit.setOnClickListener{
            saveData()
        }


        }


    private fun saveData() {

//        val database = Firebase.database
//        val myRef = database.getReference("message")
//
//        myRef.setValue("Hello, World!")
//
//        val editName = findViewById<EditText>(R.id.editTextText)
//        val editPass = findViewById<EditText>(R.id.editTextText2)

        val editName =findViewById<EditText>(R.id.sname).text.toString()
        val editemail = findViewById<EditText>(R.id.semail).text.toString()
        val editPass = findViewById<EditText>(R.id.spassword).text.toString()
        if (editName.isBlank() && editemail.isBlank() && editPass.isBlank()) {
            Toast.makeText(this, "Enter data", Toast.LENGTH_SHORT).show()
        }
        else {
            val user = User(editName, editemail, editPass)
            val studentId = userrefrence.push()
            studentId.setValue(user)

//            database = FirebaseDatabase.getInstance().getReference("User")
//            database.child(studentId).setValue(storeData)

                .addOnCompleteListener {
                    Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()

                    Handler(Looper.getMainLooper()).postDelayed({
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }, 2000)
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
        }
    }
    }