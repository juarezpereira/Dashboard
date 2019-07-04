package com.example.dashboard.delegate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dashboard.R
import com.example.dashboard.ViewType
import com.example.dashboard.ViewTypeDelegateAdapter
import com.example.dashboard.adapter.ExpensesCategoryRecyclerAdapter
import com.example.dashboard.common.BaseViewHolder
import com.example.dashboard.common.OnRecyclerClickListener
import kotlinx.android.synthetic.main.content_card_expenses_by_category.view.*

class ExpensesByCategoryDelegateAdapter(
    override val inflater: LayoutInflater,
    override val listener: OnRecyclerClickListener?
) : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ExpensesByCategoryViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        (holder as ExpensesByCategoryViewHolder).onBindView(item as ExpensesByCategoryGroup)
    }

    class ExpensesByCategoryViewHolder(
        private val inflater: LayoutInflater,
        parent: ViewGroup,
        itemView: View = inflater.inflate(R.layout.content_card_expenses_by_category, parent, false)
    ) : BaseViewHolder<ExpensesByCategoryGroup>(itemView) {

        override fun onBindView(item: ExpensesByCategoryGroup) {
            itemView.rvExpensesCategory.adapter = ExpensesCategoryRecyclerAdapter(inflater, item.list, listener)
            itemView.rvExpensesCategory.layoutManager = LinearLayoutManager(context)
            itemView.rvExpensesCategory.overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            itemView.rvExpensesCategory.isNestedScrollingEnabled = false
            itemView.rvExpensesCategory.setHasFixedSize(true)
        }

    }

}