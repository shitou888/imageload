package com.example.myapplication.imageload

import android.graphics.Bitmap
import android.util.LruCache

/*
* 内存缓存
* */
class DiskCache : ImageCache {
    private var mDiskCache: LruCache<String, Bitmap>? = null

    init {
        val maxSize: Int = (Runtime.getRuntime().maxMemory() / 1024).toInt()
        mDiskCache = object : LruCache<String, Bitmap>(maxSize) {
            override fun sizeOf(key: String?, value: Bitmap?): Int {
                return value!!.rowBytes * value.height / 1024
            }
        }
    }

    override fun get(imageUrl: String): Bitmap? {
        return mDiskCache!!.get(imageUrl)
    }

    override fun put(imageUrl: String, bmp: Bitmap) {
        mDiskCache!!.put(imageUrl, bmp)
    }
}