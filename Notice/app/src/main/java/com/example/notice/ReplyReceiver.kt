package com.example.notice

import android.app.NotificationManager
import android.app.RemoteInput
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class ReplyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        val replyTxt = RemoteInput.getResultsFromIntent(intent)
            ?.getCharSequence("key_text_reply")
        Log.d("joung","replyTxt : $replyTxt")
        //알림 취소
        val manager = context.getSystemService(
            AppCompatActivity.NOTIFICATION_SERVICE) as NotificationManager
        manager.cancel(11)

    }
}