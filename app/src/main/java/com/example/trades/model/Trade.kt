package com.example.trades.model

data class Trade(
    val symbol: String,
    val quantity: Int,
    val ltp:Double,
    val avg_price: Double,
    val close: Double
)
