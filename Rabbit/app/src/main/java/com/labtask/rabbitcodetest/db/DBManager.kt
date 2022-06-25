package com.labtask.rabbitcodetest.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.labtask.rabbitcodetest.model.Address
import com.labtask.rabbitcodetest.model.Company
import com.labtask.rabbitcodetest.model.EmployeeList
import com.labtask.rabbitcodetest.model.Geo

@Database(entities = [EmployeeList::class, Address::class, Geo::class, Company::class], version = 1)
/*@TypeConverters(
    EmployeeAddressTCHelper::class,
    EmployeeGeoTCHelper::class,
    EmployeeCompanyTCHelper::class
)*/
abstract class DBManager : RoomDatabase() {
    abstract fun employeeDao(): EmployeeDao

    companion object {
        private var instance: DBManager? = null

        @Synchronized
        fun getInstance(ctx: Context): DBManager {
            if (instance == null) {
                instance =
                    Room.databaseBuilder(
                        ctx.applicationContext,
                        DBManager::class.java,
                        "EmployeeDetailsDB.db"
                    ).build()
            }
            return instance!!
        }
    }
}