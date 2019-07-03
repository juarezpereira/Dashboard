package com.example.dashboard.delegate

import com.example.dashboard.MainGroupEnum
import com.example.dashboard.ViewType
import com.example.dashboard.adapter.MyCardItem

data class MyCardsGroup(
        val list: MutableList<MyCardItem>
) : ViewType {

    override fun getViewType(): Int = MainGroupEnum.MY_CARDS.getViewType()

}