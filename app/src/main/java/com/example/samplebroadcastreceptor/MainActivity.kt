package com.example.samplebroadcastreceptor

import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(){
    private var TAG = "Receptor"
    private val moonBroadcastReceptor = MoonBroadcastReceptor()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "OnCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "OnStart")
        val filter = IntentFilter(MoonBroadcastReceptor.EXTRA_MOON_PHASE)
        registerReceiver(moonBroadcastReceptor, filter)
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
        unregisterReceiver(moonBroadcastReceptor)  // Desregistro del receptor para evitar fugas de memoria
    }

}
