package com.example.signup.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.signup.R
import com.example.signup.sa.contact
import com.example.signup.data.User
import com.example.signup.databinding.ActivitySignBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class sign : AppCompatActivity() {

    lateinit var database: DatabaseReference
    lateinit var binding:ActivitySignBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)
        binding=ActivitySignBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val sigbuobtn=findViewById<Button>(R.id.button2)
        val btnname=findViewById<TextInputEditText>(R.id.namebtn)
        val btnmail=findViewById<TextInputEditText>(R.id.mailbtn)
        val btnpass=findViewById<TextInputEditText>(R.id.passbtn)
        val btnid=findViewById<TextInputEditText>(R.id.idbtn)

        binding.button2.setOnClickListener {
            val name=btnname.text.toString()
            val mail=btnmail.text.toString()
            val pass=btnpass.text.toString()
            val id=btnid.text.toString()

            val user= User(name,mail,pass,id)

            database=FirebaseDatabase.getInstance().getReference("users")
            database.child(id).setValue(user).addOnSuccessListener {
                Toast.makeText(this,"User Registerd",Toast.LENGTH_SHORT).show()
                val intent=Intent(this, contact::class.java)
                startActivity(intent)
            }.addOnFailureListener {
                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
            }

        }
        //val signtext=findViewById<TextView>(R.id.alredysign)
        binding.alredysign.setOnClickListener {
            val intent=Intent(this, signIn::class.java)
            startActivity(intent)
        }
    }
}