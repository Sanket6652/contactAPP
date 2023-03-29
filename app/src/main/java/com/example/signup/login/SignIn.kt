package com.example.signup.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.graphics.Color
import android.widget.Toast
import com.example.signup.R
import com.example.signup.sa.contact
import com.example.signup.databinding.ActivitySignInBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class signIn : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference
    lateinit var binding:ActivitySignInBinding
    companion object{
        const val KEY1="com.example.signup.login.signIn.name"
        const val KEY2="com.example.signup.login.signIn.mail"
        const val KEY3="com.example.signup.login.signIn.id"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        binding= ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val button: Button = findViewById(R.id.signinbtn)
        button.setBackgroundColor(Color.DKGRAY)
        supportActionBar?.hide()

        val username=findViewById<TextInputEditText>(R.id.userid)


       binding.signinbtn.setOnClickListener {
            val iduser=username.text.toString()

            if (iduser.isNotBlank()){
                readData(iduser)
            }else{
                Toast.makeText(this, "Enter details", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun readData(iduser: String) {
        databaseReference=FirebaseDatabase.getInstance().getReference("users")
        databaseReference.child(iduser).get().addOnSuccessListener {
            if (it.exists()){
                val name=it.child("name").value
                val mail=it.child("email").value
                val userID=it.child("id").value

                val  intentwelcome=Intent(this, contact::class.java)
                intentwelcome.putExtra(KEY1,name.toString())
                intentwelcome.putExtra(KEY2,mail.toString())
                intentwelcome.putExtra(KEY3,userID.toString())
                startActivity(intentwelcome)
            }else{
                Toast.makeText(this,"User does not exist",Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener{
            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
        }
    }
}