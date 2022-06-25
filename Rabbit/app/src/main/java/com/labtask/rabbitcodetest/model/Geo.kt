package com.labtask.rabbitcodetest.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Geo")
@TypeConverters
data class Geo(
    @PrimaryKey(autoGenerate = true) val sNo: Int? = 0,
    @SerializedName("lat") var lat: String? = null,
    @SerializedName("lng") var lng: String? = null
)
