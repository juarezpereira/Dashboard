package com.example.dashboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dashboard.R
import com.example.dashboard.common.BaseViewHolder
import com.example.dashboard.common.OnRecyclerClickListener
import kotlinx.android.synthetic.main.recycler_item_expenses_by_categoria.view.*

class ExpensesCategoryRecyclerAdapter(
        private val inflater: LayoutInflater,
        private val data: MutableList<ExpensesCategoryItem>,
        private val listener: OnRecyclerClickListener? = null
) : RecyclerView.Adapter<ExpensesCategoryRecyclerAdapter.ExpensesCategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpensesCategoryViewHolder {
        return ExpensesCategoryViewHolder(inflater.inflate(R.layout.recycler_item_expenses_by_categoria, parent, false))
    }

    override fun getItemCount(): Int = data.count()

    override fun onBindViewHolder(holder: ExpensesCategoryViewHolder, position: Int) {
        holder.onBindView(data[position])
    }

    inner class ExpensesCategoryViewHolder(itemView: View) : BaseViewHolder<ExpensesCategoryItem>(itemView) {
        override fun onBindView(item: ExpensesCategoryItem) {
            itemView.tvExpenseCategoryDescription.text = item.description
            itemView.tvExpenseCategoryValue.text = "R$ ${item.value}"
        }
    }

}