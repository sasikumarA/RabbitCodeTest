package com.labtask.rabbitcodetest.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.labtask.rabbitcodetest.db.EmployeeGeoTCHelper

@Entity(tableName = "Address")
@TypeConverters
data class Address(
    @PrimaryKey(autoGenerate = true) val sNo: Int? = 0,
    @SerializedName("street") var street: String? = null,
    @SerializedName("suite") var suite: String? = null,
    @SerializedName("city") var city: String? = null,
    @SerializedName("zipcode") var zipcode: String? = null/*,
    @TypeConverters(EmployeeGeoTCHelper::class)
    @SerializedName("geo") var geo: Geo? = Geo()*/
)
