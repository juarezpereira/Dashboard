package com.example.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dashboard.common.OnRecyclerClickListener

interface ViewTypeDelegateAdapter {

    val inflater: LayoutInflater

    val listener: OnRecyclerClickListener?

    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)

}