package com.example.categoryexample.ComAssistant

import java.text.SimpleDateFormat
import java.util.Date

/**
 * @author
 * 串口数据
 */
class ComBean(sPort: String, buffer: ByteArray, size: Int) {
    var bRec: ByteArray? = null
    var sRecTime: String = ""
    var sComPort: String = ""

    init {
        sComPort = sPort
        bRec = ByteArray(size)
        for (i in 0 until size) {
            bRec!![i] = buffer[i]
        }
        val sDateFormat = SimpleDateFormat("hh:mm:ss")
        sRecTime = sDateFormat.format(Date())
    }
}
