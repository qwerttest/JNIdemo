package com.jin.jnidemo.demo3

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.jin.jnidemo.R

/**
 * Des
 * @author WangJian on 2025/7/14 17
 * */
class TestService : Service() {

    val flag = true

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        //声明服务类型，试验时并未声明，启动服务时使用了startForegroundService但不调用startForeground，会Crash。
        startForeground(1, createNotification())
        Thread {
            while (flag) {
                Thread.sleep(3000)
                println("TestService = ${System.currentTimeMillis()}")
            }
        }.start()
        return super.onStartCommand(intent, flags, startId)
    }

    /**
     * 必须创建有效的通知才可以。并且必须指定到已有的notificationChannel。
     */
    private fun createNotification(): Notification {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            getSystemService(NotificationManager::class.java).createNotificationChannel(
                NotificationChannel("1111", "1111", NotificationManager.IMPORTANCE_DEFAULT))
        }

        return NotificationCompat.Builder(this, "1111").setContentTitle("TestService")
            .setContentText("running in foreground").setSmallIcon(R.mipmap.ic_launcher)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT).build()
    }
}