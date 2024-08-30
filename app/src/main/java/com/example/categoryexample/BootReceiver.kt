package com.example.categoryexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.categoryexample.ui.TestActivity

class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
            Log.d(TAG, "Boot completed")
            val startAppIntent = Intent(context, TestActivity::class.java)
            startAppIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(startAppIntent)
        }
    }

    companion object {
        private const val TAG = "BootReceiver"
    }
}