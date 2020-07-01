package com.example.myapplication.imageload
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.FileOutputStream
import java.lang.Exception

/*
* 磁盘缓存
* */
class MemoryCache : ImageCache {

    companion object {
        const val cacheDir = ""
    }

    override fun get(imageUrl: String): Bitmap? {
        return BitmapFactory.decodeFile(cacheDir + imageUrl)
    }

    override fun put(imageUrl: String, bmp: Bitmap) {
        var fileOutputStream: FileOutputStream? = null
        try {
            fileOutputStream = FileOutputStream(cacheDir + imageUrl)
            bmp.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            fileOutputStream!!.close()
        }
    }

}