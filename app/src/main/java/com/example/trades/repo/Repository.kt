package com.example.trades.repo

import com.example.trades.data.ApiClient
import com.example.trades.data.ApiInterface
import com.example.trades.util.SafeApiCall.safeApiCall

object Repository {

    private val apiService = ApiClient.getClient().create(ApiInterface::class.java)

    suspend fun getTrades() = safeApiCall {
        apiService.getTrades()
    }
}