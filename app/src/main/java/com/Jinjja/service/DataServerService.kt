package com.Jinjja.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.SystemClock
import com.Jinjja.databinding.ActivityMainBinding
import com.Jinjja.communication.TcpServerManager

class DataServerService : Service() {
    private lateinit var binding: ActivityMainBinding
    var isRunning = false

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        isRunning = true
        while(isRunning){
            SystemClock.sleep(1000)
            TcpServerManager().TcpServerThread().start()
        }

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        isRunning = false
        super.onDestroy()
    }

}