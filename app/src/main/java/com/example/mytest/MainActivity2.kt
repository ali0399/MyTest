package com.example.mytest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.mytest.databinding.ActivityMain2Binding

private const val TAG = "MainActivity2"

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private lateinit var myReceiver: BroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //Register Receiver
        myReceiver = object : BroadcastReceiver() {
            override fun onReceive(p0: Context?, intent: Intent?) {
                Log.d(TAG, "_myReceiver: onReceive-  ${intent?.getStringExtra(USERNAME)} ")
                binding.usernameTV.text = intent?.getStringExtra(USERNAME)
            }
        }
        val intentFilter = IntentFilter()
        intentFilter.addAction(MyService.MY_ACTION)
        this.registerReceiver(myReceiver, intentFilter)

    }

    override fun onStart() {
        Log.d(TAG, "onStart: start")
        //start servive
        val intent = Intent(this, MyService::class.java)
            .putExtra(USERNAME, intent.getStringExtra(USERNAME))
        startService(intent)

        super.onStart()
    }

    override fun onPause() {
        unregisterReceiver(myReceiver)
        super.onPause()
    }
}



