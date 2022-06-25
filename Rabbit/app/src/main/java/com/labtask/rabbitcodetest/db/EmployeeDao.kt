package com.labtask.rabbitcodetest.db

import androidx.room.*
import com.labtask.rabbitcodetest.model.EmployeeList

@Dao
interface EmployeeDao {
    @Query("SELECT * FROM EmployeeDetails")
    suspend fun getAll(): List<EmployeeList>?

    @Insert
    suspend fun insertAll(employeeDetail: List<EmployeeList>?)

    @Delete
    suspend fun delete(employeeDetail: EmployeeList?)

    @Update
    suspend fun update(employeeDetail: EmployeeList?)
}