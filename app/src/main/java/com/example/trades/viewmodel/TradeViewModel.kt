package com.example.trades.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trades.model.TradesResponse
import com.example.trades.repo.Repository
import com.example.trades.util.Resource
import com.example.trades.util.Status
import kotlinx.coroutines.launch

class TradeViewModel: ViewModel() {

    private val tradeData: MutableLiveData<Resource<TradesResponse>> = MutableLiveData()

    fun getTrades(): LiveData<Resource<TradesResponse>> = tradeData

    fun getAllTrades() {
        if(tradeData.value?.status == Status.SUCCESS)
            return

        tradeData.value = Resource.loading()

        viewModelScope.launch {
            tradeData.value = Repository.getTrades()
        }
    }
}