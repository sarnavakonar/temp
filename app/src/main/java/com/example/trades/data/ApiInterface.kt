package com.example.trades.data

import com.example.trades.model.TradesResponse
import retrofit2.http.GET

interface ApiInterface {

    @GET("/v3/6d0ad460-f600-47a7-b973-4a779ebbaeaf")
    suspend fun getTrades() : TradesResponse
}