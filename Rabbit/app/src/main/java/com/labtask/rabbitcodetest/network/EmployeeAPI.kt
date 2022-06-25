package com.labtask.rabbitcodetest.network

import com.labtask.rabbitcodetest.model.EmployeeList
import retrofit2.Call
import retrofit2.http.GET

interface EmployeeAPI {

    @GET("v2/5d565297300000680030a986")
    fun fetchEmployeeList(): Call<List<EmployeeList>>
}