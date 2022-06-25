package com.labtask.rabbitcodetest.module

import android.os.Bundle
import com.labtask.rabbitcodetest.EmployeeListener
import com.labtask.rabbitcodetest.R
import com.labtask.rabbitcodetest.core.BaseActivity
import com.labtask.rabbitcodetest.module.detail.EmployeeDetailsFragment
import com.labtask.rabbitcodetest.module.list.EmployeeListFragment

class EmployeeActivity : BaseActivity(), EmployeeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadEmployeeListFragment()
    }

    override fun loadEmployeeListFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.ll_EmpHolder, EmployeeListFragment.newInstance())
            .addToBackStack(EmployeeListFragment::class.java.simpleName)
            .commit()
    }

    override fun loadEmployeeDetailsFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.ll_EmpHolder, EmployeeDetailsFragment.newInstance("",""))
            .addToBackStack(EmployeeDetailsFragment::class.java.simpleName)
            .commit()
    }

}