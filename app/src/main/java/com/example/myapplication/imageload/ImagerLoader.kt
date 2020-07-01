package com.example.myapplication.imageload

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.ImageView
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Executors

class ImagerLoader {

    //图片缓存机制 默认 磁盘缓存
    private var mImageCache: ImageCache = MemoryCache()
    // 网络加载图片线程池
    private val mExecutor = Executors.newSingleThreadExecutor()

    /*
    * 配置 缓存方式
    * */
    fun setImageCache(cache: ImageCache) {
        mImageCache = cache
    }

    fun displayImage(imageUrl: String, imageView: ImageView) {
        // 缓存中获取图片资源
        val bitmap = mImageCache.get(imageUrl)
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap)
            return
        }
        //网络获取图片资源
        submitLoadRequest(imageUrl, imageView)
    }

    private fun submitLoadRequest(imageUrl: String, imageView: ImageView) {
        imageView.tag = imageUrl
        mExecutor.submit {
            val bitmap = downLoadImage(imageUrl) ?: return@submit
            if (imageView.tag == imageUrl) {
                imageView.setImageBitmap(bitmap)
            }
            mImageCache.put(imageUrl, bitmap)
        }
    }

    private fun downLoadImage(imageUrl: String): Bitmap? {
        var bitmap: Bitmap? = null
        var conn: HttpURLConnection? = null
        try {
            val url = URL(imageUrl)
            conn = url.openConnection() as HttpURLConnection?
            bitmap = BitmapFactory.decodeStream(conn!!.inputStream)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            conn!!.disconnect()
        }
        return bitmap
    }
}