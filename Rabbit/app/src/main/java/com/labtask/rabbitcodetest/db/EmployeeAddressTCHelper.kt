package com.labtask.rabbitcodetest.db

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.labtask.rabbitcodetest.model.Address

@ProvidedTypeConverter
class EmployeeAddressTCHelper {
    @TypeConverter
    fun addressToString(address: Address): String {
        return Gson().toJson(address).toString()
    }

    @TypeConverter
    fun stringToAddress(value: String): Address {
        val address = object : TypeToken<Address>() {}.type
        return Gson().fromJson(value, address)
    }
}