package com.example.dashboard

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dashboard.adapter.ExpensesCategoryItem
import com.example.dashboard.adapter.GoalsBudgetItem
import com.example.dashboard.adapter.MyCardItem
import com.example.dashboard.common.OnRecyclerClickListener
import com.example.dashboard.delegate.ExpensesByCategoryGroup
import com.example.dashboard.delegate.GoalsBudgetGroup
import com.example.dashboard.delegate.MyCardsGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnRecyclerClickListener {

    // MainGroup principal contendo a ordem escolhida pelo usuário e os grupos a serem exibidos
    private val mainGroups: MutableList<ViewType> = mutableListOf(
            ExpensesByCategoryGroup(mutableListOf(
                    ExpensesCategoryItem("Alimentação", 400.0),
                    ExpensesCategoryItem("Saúde", 300.0),
                    ExpensesCategoryItem("Escola", 200.0)
            )),
            GoalsBudgetGroup(mutableListOf(
                    GoalsBudgetItem("Viagem", 2000.0, 1.000),
                    GoalsBudgetItem("Comprar PS4", 1500.0, 1.000)
            )),
            MyCardsGroup(mutableListOf(

            ))
    )

    private lateinit var mainRecyclerAdapter: MainRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainRecyclerAdapter = MainRecyclerAdapter(this, mutableListOf(), this)
        mainRecyclerAdapter.setData(mainGroups)

        rvMain.adapter = mainRecyclerAdapter
        rvMain.layoutManager = LinearLayoutManager(this)
        rvMain.setHasFixedSize(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.menu_item_request) {
            requestMyCards()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onRecyclerClickListener(view: View, position: Int) {

    }

    private fun requestMyCards() {
        object : AsyncTask<Unit, Unit, Unit>() {

            override fun doInBackground(vararg params: Unit?) {
                Thread.sleep(3000)
            }

            override fun onPostExecute(result: Unit?) {
                super.onPostExecute(result)
                reloadMyCards(mutableListOf(
                        MyCardItem("Nubank", 2000.0, 1500.0),
                        MyCardItem("Credicard", 1600.0, 1000.0)
                ))
            }
        }.execute()
    }

    private fun reloadMyCards(list: List<MyCardItem>) {
        val viewType = mainGroups.first { it.getViewType() == MainGroupEnum.MY_CARDS.getViewType() }
        if (viewType is MyCardsGroup) {
            viewType.list.clear()
            viewType.list.addAll(list)
        }

        mainRecyclerAdapter.setData(mainGroups.toList())
    }

}