package com.labtask.rabbitcodetest.db

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.labtask.rabbitcodetest.model.Company
import com.labtask.rabbitcodetest.model.Geo

@ProvidedTypeConverter
class EmployeeGeoTCHelper {

    @TypeConverter
    fun geoToString(geo: Geo): String {
        return Gson().toJson(geo).toString()
    }

    @TypeConverter
    fun stringToGeo(value: String): List<Geo> {
        val geo = object : TypeToken<Company>() {}.type
        return Gson().fromJson(value, geo)
    }
}