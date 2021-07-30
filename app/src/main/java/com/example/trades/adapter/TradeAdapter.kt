package com.example.trades.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trades.R
import com.example.trades.model.Trade
import kotlinx.android.synthetic.main.item.view.*

class TradeAdapter(val trades: List<Trade>) : RecyclerView.Adapter<TradeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val trade = trades[position]
        holder.apply {
            name.text = trade.symbol
            ltp.text = "${trade.ltp}"
            qty.text = "${trade.quantity}"
            pbl.text = "${trade.avg_price}"
        }
    }

    override fun getItemCount(): Int {
        return trades.size
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val name = view.name
        val pbl = view.pbl
        val qty = view.qty
        val ltp = view.ltp
    }
}