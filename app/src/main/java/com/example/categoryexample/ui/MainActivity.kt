package com.example.categoryexample.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableBoolean
import com.example.categoryexample.R
import com.example.categoryexample.databinding.ActivityMainBinding
import com.example.categoryexample.domain.model.CategoryModel
import com.example.categoryexample.ui.component.CategoryItem
import com.example.categoryexample.ui.component.ModelItem
import com.example.categoryexample.ui.viewmodel.MainViewModel
import com.example.categoryexample.ui.viewmodel.MainViewModelFactory
import com.example.categoryexample.ui.viewmodel.SplashViewModel
import com.example.categoryexample.ui.viewmodel.SplashViewModelFactory
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import org.kodein.di.DIAware
import org.kodein.di.android.closestDI
import org.kodein.di.direct
import org.kodein.di.instance

class MainActivity : AppCompatActivity(), DIAware {

//    private lateinit var editTextBarcode: EditText
//    private lateinit var textViewResult: TextView

//    private val scannedData = StringBuilder()



    override val di by closestDI()
    private val mainViewModelFactory: MainViewModelFactory
        get() = di.direct.instance()

    private val mainViewModel: MainViewModel
        get() = viewModels<MainViewModel> { mainViewModelFactory }.value


    val categoryAdapter = GroupAdapter<GroupieViewHolder>()
    val modelAdapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = mainViewModel
        binding.lifecycleOwner = this


        binding.rvCategories.adapter = categoryAdapter
        binding.rvModels.adapter = modelAdapter

        mainViewModel.categories.observe(this) { categories ->
            categoryAdapter.update(categories.map {
                CategoryItem(it, mainViewModel)
            })
        }

        // Quan sát sự thay đổi của selectedCategory để cập nhật lại adapter
        mainViewModel.selectedCategory.observe(this) {
            categoryAdapter.notifyDataSetChanged()
        }

        mainViewModel.models.observe(this) { models ->
            modelAdapter.update(models.map { ModelItem(it) })
        }

//        editTextBarcode = findViewById(R.id.editTextBarcode)
//        textViewResult = findViewById(R.id.textViewResult)


//        // Cài đặt lắng nghe sự kiện phím
//        findViewById<View>(android.R.id.content).setOnKeyListener { view, keyCode, event ->
//            if (event.action == KeyEvent.ACTION_DOWN) {
//                val pressedKey = event.unicodeChar.toChar()
//                if (keyCode == KeyEvent.KEYCODE_ENTER) {
//                    processScannedData()
//                } else {
//                    println("BARCODE :: ${scannedData}")
//
//                    scannedData.append(pressedKey)
//                    textViewResult.text = scannedData.toString()
//                }
//                true
//            } else {
//                false
//            }
//        }


//
//        editTextBarcode.requestFocus()
//
//        // Lắng nghe sự kiện thay đổi văn bản trong EditText
//        editTextBarcode.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(s: Editable?) {
//                val barcodeData = s.toString() // Lấy dữ liệu từ EditText
//                textViewResult.text = "Dữ liệu mã vạch/mã QR: $barcodeData"
//            }
//
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
//        })

    }

//    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
//        if (event?.action == KeyEvent.ACTION_UP) {
//            val pressedKey = event.unicodeChar.toChar()
//            if (keyCode == KeyEvent.KEYCODE_ENTER) {
//                processScannedData()
//            } else {
//                println("BARCODE :: ${scannedData}")
//
//                scannedData.append(pressedKey)
//                textViewResult.text = scannedData.toString()
//            }
//            return true
//        }
//        return super.onKeyUp(keyCode, event)
//    }

//    private fun processScannedData() {
//        println("BARCODE :: ${scannedData}")
//
//        textViewResult.text = "Dữ liệu quét: ${scannedData.toString()}"
//        scannedData.clear()
//    }
}