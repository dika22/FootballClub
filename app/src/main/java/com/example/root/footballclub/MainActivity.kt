package com.example.root.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {
    companion object {
        val POSITION_CLUB_DATA = "FootballClub"
    }
    var items : MutableList<FootballClub> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        MainActivityUI(items).setContentView(this)
        initData()
    }

    inner class MainActivityUI(val items: List<FootballClub>) : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>)= with(ui) {
            verticalLayout {
                lparams(matchParent, matchParent)
                orientation = LinearLayout.HORIZONTAL

                recyclerView {
                    lparams(matchParent, matchParent)
                    layoutManager = LinearLayoutManager(context)
                    addItemDecoration(DividerItemDecoration(context,1))
                    adapter = FootballAdapter(items){
                        startActivity<DetailActivity>(POSITION_CLUB_DATA to it)
//                    val toast = Toast.makeText(context, it.nama_club, Toast.LENGTH_SHORT)
//                    toast.show()
                    }
                }
            }
        }
    }

    private fun initData() {
        val image = resources.obtainTypedArray(R.array.logo_club)
        val club = resources.getStringArray(R.array.club_name)
        val detail = resources.getStringArray(R.array.detail_club)

        items.clear()

        for (i in club.indices){
            items.add(FootballClub(club[i], image.getResourceId(i,0),detail[i]))
        }

        image.recycle()
    }
}
