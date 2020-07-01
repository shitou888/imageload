package com.example.myapplication.imageload

import android.graphics.Bitmap

interface ImageCache {
    fun get(imageUrl: String):Bitmap?
    fun put(imageUrl: String, bmp: Bitmap)
}