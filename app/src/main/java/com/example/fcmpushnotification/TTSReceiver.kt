package com.example.fcmpushnotification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.speech.tts.TextToSpeech
import android.util.Log

class TTSReceiver: BroadcastReceiver() {

    private var content: String? = null
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("GIAO", "Broadcast receiver")
        content = intent?.getStringExtra("data_content")
    }
}
