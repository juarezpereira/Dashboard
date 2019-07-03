package com.example.dashboard.delegate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dashboard.R
import com.example.dashboard.adapter.GoalsBudgetRecyclerAdapter
import com.example.dashboard.common.BaseViewHolder
import kotlinx.android.synthetic.main.content_card_goals_budgets.view.*

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