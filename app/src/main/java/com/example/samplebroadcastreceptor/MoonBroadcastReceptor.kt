package com.example.samplebroadcastreceptor

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import java.io.IOException
import java.io.OutputStreamWriter

class MoonBroadcastReceptor : BroadcastReceiver(){

    companion object {
        const val EXTRA_MOON_PHASE = "com.example.samplebroadcastemisor"
        val TAG = "MoonBroadcastReceiver"
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        val message = intent?.getStringExtra(EXTRA_MOON_PHASE)
        if (message != null) {
            writeToFile(message, context)
            Log.d(TAG, message)
        }
        else {
            Log.d(TAG, "No se recibio ningun mensaje")
        }
    }

    fun writeToFile(message: String?, context: Context?) {
        try {
            val outputStreamWriter = OutputStreamWriter(context?.openFileOutput("config.txt", Context.MODE_PRIVATE))

            outputStreamWriter.write(message)
            outputStreamWriter.close()
        } catch (e: IOException) {
            Log.e("Exception", "File write failed:  " + e.toString())
        }
    }

}