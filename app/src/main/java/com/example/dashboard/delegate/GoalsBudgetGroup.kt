package com.example.dashboard.delegate

import com.example.dashboard.MainGroupEnum
import com.example.dashboard.ViewType
import com.example.dashboard.adapter.GoalsBudgetItem

data class GoalsBudgetGroup(
        val list: MutableList<GoalsBudgetItem>
) : ViewType {

    override fun getViewType(): Int = MainGroupEnum.GOALS_BUDGETS.getViewType()

}