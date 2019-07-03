package com.example.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dashboard.common.OnRecyclerClickListener
import com.example.dashboard.delegate.ExpensesByCategoryDelegateAdapter
import com.example.dashboard.delegate.GoalsBudgetDelegateAdapter
import com.example.dashboard.delegate.MyCardsDelegateAdapter


class MainRecyclerAdapter @JvmOverloads constructor(
        context: Context,
        val data: MutableList<ViewType>,
        listener: OnRecyclerClickListener? = null
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var inflater: LayoutInflater = LayoutInflater.from(context)
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()

    init {
        delegateAdapters.put(
                MainGroupEnum.MY_CARDS.getViewType(),
                MyCardsDelegateAdapter(inflater, listener)
        )
        delegateAdapters.put(
                MainGroupEnum.EXPENSES_BY_CATEGORY.getViewType(),
                ExpensesByCategoryDelegateAdapter(inflater, listener)
        )
        delegateAdapters.put(
                MainGroupEnum.GOALS_BUDGETS.getViewType(),
                GoalsBudgetDelegateAdapter(inflater, listener)
        )
    }

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): RecyclerView.ViewHolder = delegateAdapters.get(viewType)!!.onCreateViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = data[position]
        val viewType = getItemViewType(position)
        delegateAdapters.get(viewType)?.onBindViewHolder(holder, item)
    }

    override fun getItemCount(): Int = data.count()

    override fun getItemViewType(position: Int) = data[position].getViewType()

    fun setData(newData: List<ViewType>) {
        val diffResult = DiffUtil.calculateDiff(DiffUtilCallback(data, newData))

        data.clear()
        data.addAll(newData)

        diffResult.dispatchUpdatesTo(this)
    }

    private class DiffUtilCallback(
            val oldList: List<ViewType>,
            val newList: List<ViewType>
    ) : DiffUtil.Callback() {

        override fun areItemsTheSame(
                oldItemPosition: Int,
                newItemPosition: Int
        ): Boolean = oldList[oldItemPosition].getViewType() == newList[newItemPosition].getViewType()

        override fun getOldListSize(): Int = oldList.count()

        override fun getNewListSize(): Int = newList.count()

        override fun areContentsTheSame(
                oldItemPosition: Int,
                newItemPosition: Int
        ): Boolean = oldList[oldItemPosition] === newList[newItemPosition]

    }

}