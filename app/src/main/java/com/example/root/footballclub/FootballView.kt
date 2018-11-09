package com.example.root.footballclub

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*


class FootballView : AnkoComponent<ViewGroup>{

    companion object {
        val logo_club = 2
        val club_name = 1
    }

    override fun createView(ui: AnkoContext<ViewGroup>) = with (ui) {

        linearLayout{
        orientation = LinearLayout.HORIZONTAL
             lparams(matchParent, wrapContent)
            padding = dip(16)

            imageView{
                id = logo_club
                imageResource = R.drawable.img_mu

            }.lparams(dip(50),dip(50))

            textView {
                id = club_name
                text = "Bumiayu FC"
            }.lparams(matchParent, wrapContent){
                margin = dip(10)
                gravity = Gravity.CENTER_VERTICAL
            }

        }
    }

}