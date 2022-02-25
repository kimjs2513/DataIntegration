package com.Jinjja.service

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.SystemClock
import android.util.Log
import com.Jinjja.databinding.ActivityMainBinding
import com.Jinjja.communication.TcpServerManager

class DataServerService : Service() {
    private lateinit var binding: ActivityMainBinding

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Log.d("test1", "서비스 시작 됨")

        var TcpThread = TcpServerManager().TcpServerThread()
        TcpThread.start()


        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        Log.d("test1", "서비스 종료 됨")
        super.onDestroy()
    }

}