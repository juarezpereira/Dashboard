package com.example.dashboard.delegate

import com.example.dashboard.MainGroupEnum
import com.example.dashboard.ViewType
import com.example.dashboard.adapter.ExpensesCategoryItem

data class ExpensesByCategoryGroup(
        var list: MutableList<ExpensesCategoryItem>
) : ViewType {

    override fun getViewType(): Int = MainGroupEnum.EXPENSES_BY_CATEGORY.getViewType()

}