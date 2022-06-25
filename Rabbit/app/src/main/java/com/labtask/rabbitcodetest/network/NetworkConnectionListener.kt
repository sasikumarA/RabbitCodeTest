package com.labtask.rabbitcodetest.network

interface NetworkConnectionListener {
    val networkMessage: String
    fun isConnected(): Boolean
}