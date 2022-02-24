package com.Jinjja

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.Jinjja.databinding.ActivityMainBinding
import com.Jinjja.service.DataServerService

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var dataserverservice_intent: Intent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.serverStartBtn.setOnClickListener {
            dataserverservice_intent = Intent(this, DataServerService::class.java)
            startService(dataserverservice_intent)
        }

        binding.serverEndBtn.setOnClickListener {
            stopService(dataserverservice_intent)
        }
    }


}