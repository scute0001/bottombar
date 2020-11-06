package com.appschool.androidclass.bottombar

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class Meow: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        Log.i("test", "test")



    }
}