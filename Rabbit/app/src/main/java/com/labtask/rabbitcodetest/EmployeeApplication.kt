package com.labtask.rabbitcodetest

import android.app.Application
import com.labtask.rabbitcodetest.db.DBManager
import com.labtask.rabbitcodetest.network.NetworkConfig

class EmployeeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        NetworkConfig.init()
       // DBManager.getInstance(applicationContext)
    }
}