package com.labtask.rabbitcodetest.db

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.labtask.rabbitcodetest.model.Company

@ProvidedTypeConverter
class EmployeeCompanyTCHelper {
    @TypeConverter
    fun companyToString(company: Company): String {
        return Gson().toJson(company).toString()
    }

    @TypeConverter
    fun stringToCompany(value: String): List<Company> {
        val company = object : TypeToken<Company>() {}.type
        return Gson().fromJson(value, company)
    }
}