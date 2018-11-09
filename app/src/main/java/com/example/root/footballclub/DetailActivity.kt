package com.example.root.footballclub

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Gravity
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val list = intent.getParcelableExtra<FootballClub>(MainActivity.POSITION_CLUB_DATA)
        Log.e("datanya :", list.toString())
        DetailActivityView(list).setContentView(this)

    }

    inner class DetailActivityView(val items: FootballClub) : AnkoComponent<DetailActivity>{

        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui){
            linearLayout {
                orientation = LinearLayout.VERTICAL
                lparams(matchParent, wrapContent)

                imageView {
                    Glide.with(this).load(items.logo).into(this)
                    id = FootballView.logo_club
                    padding = dip(15)

                    this@linearLayout.gravity = Gravity.CENTER_HORIZONTAL
                }.lparams(dip(150),dip(150))
//                Log.e("infonya :", list.nama_club)
                textView {
                    id = FootballView.club_name
                    text = items.nama_club
                    textSize = sp(10).toFloat()
                    gravity = Gravity.CENTER_HORIZONTAL
                    padding = dip(10)

                }

                textView {
                    text = items.detail
                    gravity = Gravity.CENTER_HORIZONTAL
                    padding = dip(10)
                }
            }
        }

    }


}

