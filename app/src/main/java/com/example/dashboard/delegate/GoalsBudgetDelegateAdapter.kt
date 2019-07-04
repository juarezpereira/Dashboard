package com.example.dashboard.delegate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dashboard.R
import com.example.dashboard.ViewType
import com.example.dashboard.ViewTypeDelegateAdapter
import com.example.dashboard.adapter.GoalsBudgetRecyclerAdapter
import com.example.dashboard.common.BaseViewHolder
import com.example.dashboard.common.OnRecyclerClickListener
import kotlinx.android.synthetic.main.content_card_goals_budgets.view.*

class GoalsBudgetDelegateAdapter(
    override val inflater: LayoutInflater,
    override val listener: OnRecyclerClickListener?
) : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return GoalsBudgetViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        (holder as GoalsBudgetViewHolder).onBindView(item as GoalsBudgetGroup)
    }

    class GoalsBudgetViewHolder(
        private val inflater: LayoutInflater,
        parent: ViewGroup,
        itemView: View = inflater.inflate(R.layout.content_card_goals_budgets, parent, false)
    ) : BaseViewHolder<GoalsBudgetGroup>(itemView) {

        override fun onBindView(item: GoalsBudgetGroup) {
            itemView.rvGoals.adapter = GoalsBudgetRecyclerAdapter(inflater, item.list, listener)
            itemView.rvGoals.layoutManager = LinearLayoutManager(context)
            itemView.rvGoals.overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            itemView.rvGoals.isNestedScrollingEnabled = false
            itemView.rvGoals.setHasFixedSize(true)
        }

    }

}