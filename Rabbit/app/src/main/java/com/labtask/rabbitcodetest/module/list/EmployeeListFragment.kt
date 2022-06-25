package com.labtask.rabbitcodetest.module.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.labtask.rabbitcodetest.R
import com.labtask.rabbitcodetest.db.DBManager
import com.labtask.rabbitcodetest.model.EmployeeList
import com.labtask.rabbitcodetest.network.NetworkConfig
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmployeeListFragment : Fragment() {

    companion object {
        fun newInstance() = EmployeeListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_employee_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val call = NetworkConfig.employeeAPI.fetchEmployeeList()
        call.enqueue(object : Callback<List<EmployeeList>> {
            override fun onResponse(
                call: Call<List<EmployeeList>>,
                response: Response<List<EmployeeList>>
            ) {
                Log.e( "onResponse: ",Gson().toJson(response.body()).toString())
            }

            override fun onFailure(call: Call<List<EmployeeList>>, t: Throwable) {

            }
        })

        /*runBlocking {
            val instance = DBManager.getInstance(requireContext())
            val employeeDetails: List<EmployeeList>? = instance.employeeDao().getAll()
            if (employeeDetails != null && employeeDetails.isNotEmpty()
            ) {
                instance.employeeDao().insertAll(employeeDetails)
            } else {
                val call = NetworkConfig.employeeAPI.fetchEmployeeList()
                call.enqueue(object : Callback<List<EmployeeList>> {
                    override fun onResponse(
                        call: Call<List<EmployeeList>>,
                        response: Response<List<EmployeeList>>
                    ) {
                        Log.e("onResponse: ", Gson().toJson(response.body()).toString())
                    }

                    override fun onFailure(call: Call<List<EmployeeList>>, t: Throwable) {

                    }
                })
            }
        }*/
    }

}