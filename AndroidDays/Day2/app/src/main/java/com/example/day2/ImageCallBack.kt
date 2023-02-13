package com.example.day2

import android.graphics.Bitmap

interface ImageCallBack {
    fun failed()
    fun success(decodeStream: Bitmap)

}
