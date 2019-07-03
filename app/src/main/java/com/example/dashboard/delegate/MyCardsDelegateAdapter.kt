package com.example.dashboard.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dashboard.R
import com.example.dashboard.ViewType
import com.example.dashboard.ViewTypeDelegateAdapter
import com.example.dashboard.common.OnRecyclerClickListener

class MyCardsDelegateAdapter(
    override val inflater: LayoutInflater,
    override val listener: OnRecyclerClickListener?
) : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return MyCardsViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        (holder as MyCardsViewHolder).onBindView(item as MyCardsGroup)
    }

}