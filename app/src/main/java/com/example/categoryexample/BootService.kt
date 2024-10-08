package com.example.categoryexample

import com.example.categoryexample.ui.TestActivity

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import androidx.core.app.NotificationCompat

class BootService : Service() {
    private val handler = Handler(Looper.getMainLooper())

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent == null) {
            return START_NOT_STICKY
        }

        createNotificationChannel()
        val notification = createNotification()
        startForeground(NOTIFICATION_ID, notification)

        handler.postDelayed({
            val startAppIntent = Intent(this, TestActivity::class.java)
            startAppIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(startAppIntent)

            stopSelf()
        }, 5000)

        return START_STICKY
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Boot Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }

    private fun createNotification(): Notification {
        // Tạo PendingIntent để mở ứng dụng khi nhấp vào thông báo
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            Intent(this, TestActivity::class.java),
            PendingIntent.FLAG_IMMUTABLE
        )

        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("App Started")
            .setContentText("Your app has been started after device boot")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()
    }

    override fun onBind(intent: Intent?): IBinder? = null

    companion object {
        private const val NOTIFICATION_ID = 1
        private const val CHANNEL_ID = "BootServiceChannel"
    }
}