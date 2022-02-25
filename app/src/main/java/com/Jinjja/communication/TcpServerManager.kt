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

    inner class TcpServerThread: Thread(){
        override fun run() {
            while (isRunnig) {
                SystemClock.sleep(1000)
                try {

                    Log.d("test1", "쓰래드 시작")

                    var socket = Socket("192.168.0.100", 55555)

                    var input = socket.getInputStream()
                    var dis = DataInputStream(input)

                    var output = socket.getOutputStream()
                    var dos = DataOutputStream(output)

                    var data1 = dis.readInt()

                    dos.writeInt(200)
                    dos.writeDouble(22.22)
                    dos.writeUTF("클라이언트가 보낸 문자열")

                    socket.close()

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

        }
    }

}