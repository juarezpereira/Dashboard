package com.example.dashboard.common

import android.content.Context
import android.content.res.Resources
import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<in T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    protected val context: Context = itemView.context
    protected val res: Resources = context.resources

    var listener: OnRecyclerClickListener? = null

    abstract fun onBindView(item: T)
}