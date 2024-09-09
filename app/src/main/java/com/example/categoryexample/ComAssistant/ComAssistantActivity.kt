package com.example.categoryexample.ComAssistant

import android.app.Activity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.categoryexample.R
import java.io.IOException
import java.security.InvalidParameterException

class ComAssistantActivity : Activity() {
    private var editTextRecDisp: EditText? = null // EditText để hiển thị dữ liệu nhận được
    private var ComA: SerialControl? = null // Điều khiển cổng nối tiếp A

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_com_assistant)

        // Khởi tạo các thành phần giao diện
        editTextRecDisp = findViewById(R.id.editTextRecDisp)

        // Khởi tạo cổng ComA với mặc định /dev/ttysWK2 và baudrate 9600
        ComA = SerialControl("/dev/ttysWK2", 9600)

        // Mở cổng nối tiếp ComA ngay lập tức
        openComPort(ComA!!)

        // Hiển thị trạng thái kết nối
        Toast.makeText(this, "ComA is connected.", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        closeComPort(ComA) // Đóng cổng nối tiếp ComA khi ứng dụng bị hủy
    }

    // Hàm mở cổng nối tiếp
    private fun openComPort(comPort: SerialControl) {
        try {
            comPort.open()
        } catch (e: SecurityException) {
            showMessage("Permission denied for serial port.")
        } catch (e: IOException) {
            showMessage("Failed to open serial port.")
        } catch (e: InvalidParameterException) {
            showMessage("Invalid parameters.")
        }
    }

    // Hàm đóng cổng nối tiếp
    private fun closeComPort(comPort: SerialControl?) {
        comPort?.close()
    }

    // Hàm hiển thị thông báo lỗi
    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    // Lớp con xử lý giao tiếp cổng nối tiếp
    private inner class SerialControl(sPort: String?, iBaudRate: Int) :
        SerialHelper(sPort!!, iBaudRate) {
        override fun onDataReceived(ComRecData: ComBean?) {
            runOnUiThread { // Lấy dữ liệu từ ComRecData và chuyển đổi sang chuỗi
                val receivedData = ComRecData?.bRec?.decodeToString()?.trim() // Sử dụng bRec để lấy mảng byte từ ComRecData
                // Hiển thị dữ liệu nhận được lên EditText
                editTextRecDisp!!.append(receivedData)
            }
        }
    }
}
