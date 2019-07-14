package io.github.luteoos.booker

import android.app.Application
import android.os.StrictMode
import androidx.appcompat.app.AppCompatDelegate

class BookerApp : Application() {

    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG)
            initDebugStuff()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    private fun initDebugStuff(){
        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()
                .penaltyLog()
                .build())
        StrictMode.setVmPolicy(
            StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .detectLeakedClosableObjects()
                .penaltyLog()
                .penaltyDeath()
                .build())
    }
}