package com.example.root.footballclub


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FootballClub(val nama_club : String?, val logo : Int?, val detail : String?) : Parcelable