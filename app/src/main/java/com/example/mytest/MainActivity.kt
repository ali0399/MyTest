package com.example.mytest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mytest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var username = ""
        var password = ""

        binding.LoginBtn.setOnClickListener {
            username = binding.usernameET.text.toString()
            password = binding.passwordET.text.toString()

            if (username != "" && password != "") {
                startActivity(Intent(this, MainActivity2::class.java)
                    .putExtra(USERNAME, username)
                    .putExtra(PASSWORD, password))
            } else {
                Toast.makeText(this, "Enter valid details!", Toast.LENGTH_SHORT).show()
            }


        }
    }

}