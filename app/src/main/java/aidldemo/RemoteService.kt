package aidldemo

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.example.myapplication.RemoteAidlInterface

class RemoteService : Service() {

    private var mBinder: MyBinder? = null
    override fun onCreate() {
        super.onCreate()
        if (mBinder == null) {
            mBinder = MyBinder()
        }
    }

    override fun onBind(p0: Intent?): IBinder? {
        return mBinder
    }

    inner class MyBinder : RemoteAidlInterface.Stub() {
        override fun getName(): String {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun setName(name: String?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun basicTypes(
            anInt: Int,
            aLong: Long,
            aBoolean: Boolean,
            aFloat: Float,
            aDouble: Double,
            aString: String?
        ) {

        }


    }
}