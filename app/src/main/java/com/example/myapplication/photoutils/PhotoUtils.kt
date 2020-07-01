package com.example.myapplication.photoutils

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.view.Gravity
import com.example.myapplication.R

//class PhotoUtils {
//
//    private var mDialog: Dialog? = null
//    private var maxCount = 0
//    private var context: Activity? = null
//
//    class Builder {
//        var maxCount = 0
//        var context: Activity? = null
//
//        fun Builder() {}
//        fun maxCount(maxCount: Int): Builder {
//            this.maxCount = maxCount
//            return this
//        }
//
//        fun Context(context: Activity): Builder {
//            this.context = context
//            return this
//        }
//
//        fun build(): PhotoUtils {
//            return PhotoUtils(this)
//        }
//    }
//
//    private constructor(builder: Builder) {
//        maxCount = builder.maxCount
//        context = builder.context
//    }
//
//    fun show() {
//        mDialog = Dialog(context!!, R.style.Theme_AppCompat_Dialog_Alert)
//
//
//        val display = context!!.windowManager.defaultDisplay
//        mDialog!!.window!!.setGravity(Gravity.BOTTOM)
//        mDialog!!.setContentView()
//
//    }
//}