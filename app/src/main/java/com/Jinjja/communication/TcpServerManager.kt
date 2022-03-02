package com.Jinjja.communication
import android.os.Handler
import android.os.SystemClock
import android.util.Log
import com.Jinjja.databinding.ActivityMainBinding
import java.io.DataInputStream
import java.io.DataOutputStream
import java.lang.Exception
import java.net.Socket
import com.Jinjja.service.DataServerService

class TcpServerManager {


    private lateinit var binding: ActivityMainBinding

    var isRunnig = true

    var value = 60

    inner class TcpServerThread: Thread(){
        override fun run() {
                try {
                    while (!Thread.interrupted()) {
                        Log.d("test1", "쓰래드 시작")

                        var socket = Socket("192.168.0.100", 55555)

                        var input = socket.getInputStream()
                        var dis = DataInputStream(input)

                        var output = socket.getOutputStream()
                        var dos = DataOutputStream(output)

                        var data1 = dis.readInt()

                        value++

                        dos.writeInt(value)

                        socket.close()
                        SystemClock.sleep(1L)
                    }

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

        }


}