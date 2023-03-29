package com.example.signup.data

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.signup.R
import com.example.signup.sa.contact
import com.example.signup.databinding.ActivityAddcontactBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class addcontact : AppCompatActivity() {
    lateinit var database: DatabaseReference
    lateinit var binding:ActivityAddcontactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addcontact)
        binding= ActivityAddcontactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val name=findViewById<TextInputEditText>(R.id.name)
        val phone=findViewById<TextInputEditText>(R.id.phoneno)

        binding.add.setOnClickListener {
            val name=name.text.toString()
            val phone=phone.text.toString()

            val phonecontact= contactdata(name,phone)
            database= FirebaseDatabase.getInstance().getReference("contact")
            database.child(name).setValue(phonecontact).addOnSuccessListener {
                Toast.makeText(this,"New contact added successfully", Toast.LENGTH_SHORT).show()
                val intent=Intent(this, contact::class.java)
                startActivity(intent)
            }.addOnFailureListener {
                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
            }
        }


    }
}