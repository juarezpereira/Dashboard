package com.example.dashboard

enum class MainGroupEnum {

    MY_CARDS {
        override fun getViewType(): Int = ordinal
    },
    EXPENSES_BY_CATEGORY {
        override fun getViewType(): Int = ordinal
    },
    GOALS_BUDGETS {
        override fun getViewType(): Int = ordinal
    };

    abstract fun getViewType(): Int

}