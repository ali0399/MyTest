package com.example.mytest

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

private const val TAG = "MyService"

class MyService:Service() {

    val binder: IBinder? =null

    override fun onBind(p0: Intent?): IBinder? = binder

    companion object{
        const val MY_ACTION = "com.example.mytest.MY_ACTION";
    }

   override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

       Log.d(TAG, "onStartCommand: ${intent?.getStringExtra(USERNAME)}")

       val myIntent = Intent().apply {
           action = MY_ACTION
           putExtra(USERNAME, intent?.getStringExtra(USERNAME))
       }
       this.sendBroadcast(myIntent)
       return START_NOT_STICKY
   }

}