package com.example.categoryexample.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.categoryexample.databinding.ActivityTestBinding
import com.roco.api.weigenRelay.weigenRelay

class TestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTestBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        if (intent.flags and Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT != 0) {
            finish()
            return
        }

        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOpenGreenLight.setOnClickListener{
            val intent = Intent().apply {
                action = "com.custom.green.light.open"
                addFlags(Intent.FLAG_RECEIVER_FOREGROUND)
            }
            applicationContext.sendBroadcast(intent)
        }

        binding.btnCloseGreenLight.setOnClickListener{
            val intent = Intent()
            intent.setAction("com.custom.green.light.close")
            intent.addFlags(Intent.FLAG_RECEIVER_FOREGROUND)
            applicationContext.sendBroadcast(intent)

        }

        //open RedInfre light
        binding.btnOpenRedInfreLight.setOnClickListener {
            val intent = Intent().apply {
                action = "com.custom.red_infre.light.open"
                addFlags(Intent.FLAG_RECEIVER_FOREGROUND)
            }
            applicationContext.sendBroadcast(intent)
        }


        //close RedInfre light
        binding.btnCloseRedInfreLight.setOnClickListener{
            val intent = Intent()
            intent.setAction("com.custom.red_infre.light.close")
            intent.addFlags(Intent.FLAG_RECEIVER_FOREGROUND)
            applicationContext.sendBroadcast(intent)
        }


        //open white light
        binding.btnOpenWhiteLight.setOnClickListener {
            val intent = Intent().apply {
                action = "com.custom.white.light.open"
                addFlags(Intent.FLAG_RECEIVER_FOREGROUND)
            }
            applicationContext.sendBroadcast(intent)
        }


        //close white light
        binding.btnCloseWhiteLight.setOnClickListener{
            val intent = Intent()
            intent.setAction("com.custom.white.light.close")
            intent.addFlags(Intent.FLAG_RECEIVER_FOREGROUND)
            applicationContext.sendBroadcast(intent)
        }

        //open red light
        binding.btnOpenRedLight.setOnClickListener {
            val intent = Intent().apply {
                action = "com.custom.red.light.open"
                addFlags(Intent.FLAG_RECEIVER_FOREGROUND)
            }
            applicationContext.sendBroadcast(intent)
        }


        //close red light
        binding.btnCloseRedLight.setOnClickListener{
            val intent = Intent()
            intent.setAction("com.custom.red.light.close")
            intent.addFlags(Intent.FLAG_RECEIVER_FOREGROUND)
            applicationContext.sendBroadcast(intent)
        }

        //open relay
        binding.btnOpenRelay.setOnClickListener {
            val intent = Intent().apply {
                action = "com.custom.relay.open"
                addFlags(Intent.FLAG_RECEIVER_FOREGROUND)
            }
            applicationContext.sendBroadcast(intent)
        }

        //close relay
        binding.btnCloseRelay.setOnClickListener{
            val intent = Intent()
            intent.setAction("com.custom.relay.close")
            intent.addFlags(Intent.FLAG_RECEIVER_FOREGROUND)
            applicationContext.sendBroadcast(intent)
        }

        //open status bar
        binding.btnOpenStatusBar.setOnClickListener {
            val intent = Intent().apply {
                action = "com.custom.open.statubar"
                addFlags(Intent.FLAG_RECEIVER_FOREGROUND)
            }
            applicationContext.sendBroadcast(intent)
        }

        //close status bar
        binding.btnCloseStatusBar.setOnClickListener{
            val intent = Intent()
            intent.setAction("com.custom.close.statubar")
            intent.addFlags(Intent.FLAG_RECEIVER_FOREGROUND)
            applicationContext.sendBroadcast(intent)
        }

        //open show navigation bar
        binding.btnShowNavigationbar.setOnClickListener {
            val intent = Intent().apply {
                action = "com.custom.show_navigationbar"
                addFlags(Intent.FLAG_RECEIVER_FOREGROUND)
            }
            applicationContext.sendBroadcast(intent)
        }

        //close hide navigation bar
        binding.btnHideNavigationbar.setOnClickListener{
            val intent = Intent()
            intent.setAction("com.custom.hide_navigationbar")
            intent.addFlags(Intent.FLAG_RECEIVER_FOREGROUND)
            applicationContext.sendBroadcast(intent)
        }

        //open show status bar
        binding.btnShowStatusbar.setOnClickListener {
            val intent = Intent().apply {
                action = "roco.systemui.show_statusbar"
                addFlags(Intent.FLAG_RECEIVER_FOREGROUND)
            }
            applicationContext.sendBroadcast(intent)
        }

        //close hide status bar
        binding.btnHideStatusbar.setOnClickListener{
            val intent = Intent()
            intent.setAction("roco.systemui.hide_statusbar")
            intent.addFlags(Intent.FLAG_RECEIVER_FOREGROUND)
            applicationContext.sendBroadcast(intent)
        }

        binding.btnSetGpioDirIn22.setOnClickListener {
            val ii = weigenRelay(this)
            ii.setGpioDirIn(22)
            Log.d("xxxxxxxchuan", "------11111:")
            val result = ii.getGpioInData(22)
            Log.d("xxxxxxxchuan", "------22222")
            Log.d("xxxxxxxchuan", "------result:$result")
            if (result == 1) {
                Toast.makeText(applicationContext, "......来人了...", Toast.LENGTH_LONG).show()
            } else if (result == 0) {
                Toast.makeText(applicationContext, "没有人来.........", Toast.LENGTH_LONG).show()
            }
        }

        binding.btnSetGpioDirIn161.setOnClickListener {
            val ii = weigenRelay(this)
            ii.setGpioDirIn(161)
            val result = ii.getGpioInData(161)
            if (result == 1) {
                Toast.makeText(applicationContext, "IO4 GPIO 高", Toast.LENGTH_LONG).show()
            } else if (result == 0) {
                Toast.makeText(applicationContext, "IO4 GPIO 低", Toast.LENGTH_LONG).show()
            }
        }

        binding.btnSetGpioDirIn164.setOnClickListener {
            val ii = weigenRelay(this)
            ii.setGpioDirIn(164)
            val result = ii.getGpioInData(164)
            if (result == 1) {
                Toast.makeText(applicationContext, "IO5 GPIO 高", Toast.LENGTH_LONG).show()
            } else if (result == 0) {
                Toast.makeText(applicationContext, "IO5 GPIO 低", Toast.LENGTH_LONG).show()
            }
        }
    }
}