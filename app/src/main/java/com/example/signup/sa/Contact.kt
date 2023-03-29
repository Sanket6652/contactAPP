package com.example.signup.sa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.signup.data.addcontact
import com.example.signup.databinding.ActivityContactBinding
import com.example.signup.sa.searchcontact

class contact : AppCompatActivity() {
    lateinit var binding: ActivityContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.fabadd.setOnClickListener{
           val intent=Intent(this, addcontact::class.java)
            startActivity(intent)
        }

        binding.fabsearch.setOnClickListener{
            val intent=Intent(this, searchcontact::class.java)
            startActivity(intent)
        }

    }
}