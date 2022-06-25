package com.labtask.rabbitcodetest.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Company")
@TypeConverters
data class Company(
    @PrimaryKey(autoGenerate = true) val sNo: Int?=0,
    @SerializedName("name") var name: String? = null,
    @SerializedName("catchPhrase") var catchPhrase: String? = null,
    @SerializedName("bs") var bs: String? = null
)
