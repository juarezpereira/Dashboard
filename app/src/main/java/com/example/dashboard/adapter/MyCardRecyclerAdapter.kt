package com.example.dashboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dashboard.R
import com.example.dashboard.common.BaseViewHolder
import com.example.dashboard.common.OnRecyclerClickListener
import kotlinx.android.synthetic.main.recycler_item_my_card.view.*

class MyCardRecyclerAdapter(
        private val inflater: LayoutInflater,
        private val data: MutableList<MyCardItem>,
        private val listener: OnRecyclerClickListener? = null
) : RecyclerView.Adapter<MyCardRecyclerAdapter.MyCardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCardViewHolder {
        return MyCardViewHolder(inflater.inflate(R.layout.recycler_item_my_card, parent, false))
    }

    override fun getItemCount(): Int = data.count()

    override fun onBindViewHolder(holder: MyCardViewHolder, position: Int) {
        holder.onBindView(data[position])
    }

    inner class MyCardViewHolder(itemView: View) : BaseViewHolder<MyCardItem>(itemView) {
        override fun onBindView(item: MyCardItem) {
            itemView.tvCardTitle.text = item.name
            itemView.tvCardTotalOf.text = "R$ ${item.invoiceValue} de R\$ ${item.limitValue}"
        }
    }

}