package com.example.dashboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dashboard.R
import com.example.dashboard.common.BaseViewHolder
import com.example.dashboard.common.OnRecyclerClickListener
import kotlinx.android.synthetic.main.recycler_item_goal.view.*

class GoalsBudgetRecyclerAdapter(
        private val inflater: LayoutInflater,
        private val data: MutableList<GoalsBudgetItem>,
        private val listener: OnRecyclerClickListener? = null
) : RecyclerView.Adapter<GoalsBudgetRecyclerAdapter.GoalsBudgetViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoalsBudgetViewHolder {
        return GoalsBudgetViewHolder(inflater.inflate(R.layout.recycler_item_goal, parent, false))
    }

    override fun getItemCount(): Int = data.count()

    override fun onBindViewHolder(holder: GoalsBudgetViewHolder, position: Int) {
        holder.onBindView(data[position])
    }

    inner class GoalsBudgetViewHolder(itemView: View) : BaseViewHolder<GoalsBudgetItem>(itemView) {
        override fun onBindView(item: GoalsBudgetItem) {
            itemView.tvGoalName.text = item.name
            itemView.tvGoalTotalOf.text = "R$ ${item.savedValue} de R\$ ${item.goalValue}"
        }
    }

}