package com.example.categoryexample.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.categoryexample.KioskModeHelper
import com.example.categoryexample.databinding.ActivityTestBinding
import com.roco.api.weigenRelay.weigenRelay

class TestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTestBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOpenGreenLight.setOnClickListener{
            KioskModeHelper.sendCommand(this, KioskModeHelper.Action.OPEN_GREEN_LIGHT)
        }

        binding.btnCloseGreenLight.setOnClickListener{
            KioskModeHelper.sendCommand(this, KioskModeHelper.Action.CLOSE_GREEN_LIGHT)
        }

        //open white light
        binding.btnOpenWhiteLight.setOnClickListener {
            KioskModeHelper.sendCommand(this, KioskModeHelper.Action.OPEN_WHITE_LIGHT)
        }


        //close white light
        binding.btnCloseWhiteLight.setOnClickListener{
            KioskModeHelper.sendCommand(this, KioskModeHelper.Action.CLOSE_WHITE_LIGHT)
        }

        //open red light
        binding.btnOpenRedLight.setOnClickListener {
            KioskModeHelper.sendCommand(this, KioskModeHelper.Action.OPEN_RED_LIGHT)
        }


        //close red light
        binding.btnCloseRedLight.setOnClickListener{
            KioskModeHelper.sendCommand(this, KioskModeHelper.Action.CLOSE_RED_LIGHT)
        }

        //open relay
        binding.btnOpenRelay.setOnClickListener {
            KioskModeHelper.sendCommand(this, KioskModeHelper.Action.OPEN_RELAY)
        }

        //close relay
        binding.btnCloseRelay.setOnClickListener{
            KioskModeHelper.sendCommand(this, KioskModeHelper.Action.CLOSE_RELAY)
        }

        //open status bar
        binding.btnOpenStatusBar.setOnClickListener {
            KioskModeHelper.sendCommand(this, KioskModeHelper.Action.OPEN_STATUS_BAR)
        }

        //close status bar
        binding.btnCloseStatusBar.setOnClickListener{
            KioskModeHelper.sendCommand(this, KioskModeHelper.Action.CLOSE_STATUS_BAR)
        }

        //open show navigation bar
        binding.btnShowNavigationbar.setOnClickListener {
            KioskModeHelper.sendCommand(this, KioskModeHelper.Action.SHOW_NAVIGATION_BAR)
        }

        //close hide navigation bar
        binding.btnHideNavigationbar.setOnClickListener{
            KioskModeHelper.sendCommand(this, KioskModeHelper.Action.HIDE_NAVIGATION_BAR)
        }

        //open show status bar
        binding.btnShowStatusbar.setOnClickListener {
            KioskModeHelper.sendCommand(this, KioskModeHelper.Action.SHOW_STATUS_BAR)
        }

        //close hide status bar
        binding.btnHideStatusbar.setOnClickListener{
            KioskModeHelper.sendCommand(this, KioskModeHelper.Action.HIDE_STATUS_BAR)
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