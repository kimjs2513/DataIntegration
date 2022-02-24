package com.Jinjja.communication
import com.Jinjja.databinding.ActivityMainBinding
import java.io.DataInputStream
import java.io.DataOutputStream
import java.lang.Exception
import java.net.Socket

class TcpServerManager {
    private lateinit var binding: ActivityMainBinding

    inner class TcpServerThread: Thread(){
        override fun run() {
            try{
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

                binding.cameraDataText.text = data1.toString()


            }catch (e:Exception){
                e.printStackTrace()
            }
        }


    }

}