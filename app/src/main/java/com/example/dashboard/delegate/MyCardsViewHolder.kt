package com.example.dashboard.delegate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dashboard.R
import com.example.dashboard.adapter.MyCardRecyclerAdapter
import com.example.dashboard.common.BaseViewHolder
import kotlinx.android.synthetic.main.content_card_my_cards.view.*

class MyCardsViewHolder(
        private val inflater: LayoutInflater,
        parent: ViewGroup,
        itemView: View = inflater.inflate(R.layout.content_card_my_cards, parent, false)
) : BaseViewHolder<MyCardsGroup>(itemView) {

    override fun onBindView(item: MyCardsGroup) {
        itemView.cardEmpty.visibility = if (item.list.isEmpty()) View.VISIBLE else View.GONE

        itemView.rvMyCards.adapter = MyCardRecyclerAdapter(inflater, item.list, listener)
        itemView.rvMyCards.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        itemView.rvMyCards.overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        itemView.rvMyCards.setHasFixedSize(true)
    }

}