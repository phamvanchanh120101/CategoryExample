package com.example.categoryexample.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.categoryexample.R
import com.example.categoryexample.databinding.ActivityTestBinding
import com.example.categoryexample.domain.model.ItemReturnModel
import com.example.categoryexample.domain.model.LockerInfo

class TestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTestBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemReturnModel = LockerInfo("1", "483", "SSD 480GB Sandisk E50 HSKFHN", "0923-9329i30832", "LAPTOP C", "09023")
        binding.collectItem.lockerInfo = itemReturnModel
    }
}