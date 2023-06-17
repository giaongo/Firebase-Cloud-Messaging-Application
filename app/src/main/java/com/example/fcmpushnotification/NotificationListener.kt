package com.example.fcmpushnotification

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.speech.tts.TextToSpeech
import android.util.Log
import java.util.Locale

class NotificationListener: NotificationListenerService() {
    private var content:String? = null

    private lateinit var textToSpeech: TextToSpeech


    override fun onNotificationPosted(sbn: StatusBarNotification) {
        super.onNotificationPosted(sbn)
        content = sbn.notification.extras.getString("android.text")

        if(sbn.notification.channelId == "fcm_fallback_notification_channel") {

            textToSpeech.speak(content, TextToSpeech.QUEUE_FLUSH, null, "officer notification")
        }
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("Giao", "init NotificationListener")
        textToSpeech = TextToSpeech(applicationContext) {
            if(it != TextToSpeech.ERROR) {
                textToSpeech.language = Locale.ENGLISH
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
       textToSpeech.shutdown()
    }
}