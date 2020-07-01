package com.example.myapplication.imageload

import android.graphics.Bitmap

/*
* 双缓存
* */
class DoubleCache :ImageCache{
    private val mMemoryCache = MemoryCache()
    private val mDiskCache = DiskCache()

    override fun get(imageUrl: String): Bitmap? {
        var bitmap: Bitmap?
        bitmap = mMemoryCache.get(imageUrl)
        if (bitmap == null) {
            bitmap = mDiskCache.get(imageUrl)
        }
        return bitmap
    }

    override fun put(imageUrl: String, bmp: Bitmap) {
        mMemoryCache.put(imageUrl, bmp)
        mDiskCache.put(imageUrl, bmp)
    }
}