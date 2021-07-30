package com.example.trades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trades.adapter.TradeAdapter
import com.example.trades.util.Status
import com.example.trades.viewmodel.TradeViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom.*

class MainActivity : AppCompatActivity() {

    private var viewModel: TradeViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(TradeViewModel::class.java)

        viewModel?.getAllTrades()

        viewModel?.getTrades()?.observe(this, Observer {
            when(it?.status){
                Status.SUCCESS -> {
                    val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                    rv.layoutManager = linearLayoutManager
                    rv.adapter = TradeAdapter(it.data?.data!!)
                }
                Status.ERROR -> {
                }
                Status.LOADING -> {
                }
            }
        })

        showBottomSheet()
    }

    private fun showBottomSheet() {
        val bottomSheetDialog = BottomSheetDialog(this)
        val view: View = LayoutInflater.from(this).inflate(R.layout.bottom, root)

        bottomSheetDialog.setCancelable(false)
        bottomSheetDialog.setContentView(view)
        bottomSheetDialog.setCanceledOnTouchOutside(true)
        val mBehavior = BottomSheetBehavior.from(view.getParent() as View)
        mBehavior.setPeekHeight(100)
        bottomSheetDialog.show()
    }
}