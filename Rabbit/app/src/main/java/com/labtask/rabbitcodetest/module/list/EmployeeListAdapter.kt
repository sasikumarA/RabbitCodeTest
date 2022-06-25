package com.labtask.rabbitcodetest.module.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.labtask.rabbitcodetest.R
import com.labtask.rabbitcodetest.model.EmployeeList

class EmployeeListAdapter(
    var employeeList: List<EmployeeList>?,
    var context: Context?
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return EmployeeListViewHolder(
            LayoutInflater.from(context).inflate(R.layout.rc_employee_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val employeeListViewHolder = holder as EmployeeListViewHolder
    }

    override fun getItemCount(): Int {
        employeeList?.let {
            if (it.isNotEmpty()) {
                return it.size
            }
        }
        return 0
    }

    class EmployeeListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}