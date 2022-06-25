package com.labtask.rabbitcodetest.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.labtask.rabbitcodetest.db.EmployeeAddressTCHelper
import com.labtask.rabbitcodetest.db.EmployeeCompanyTCHelper

@Entity(tableName = "EmployeeDetails")
data class EmployeeList(
    @PrimaryKey(autoGenerate = true) val sNo: Int? = 0,
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("username") var username: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("profile_image") var profileImage: String? = null,
    /*@TypeConverters(EmployeeAddressTCHelper::class)
    @SerializedName("address") var address: Address? = Address(),*/
    @SerializedName("phone") var phone: String? = null,
    @SerializedName("website") var website: String? = null/*,
    @TypeConverters(EmployeeCompanyTCHelper::class)
    @SerializedName("company") var company: Company? = Company()*/
)



