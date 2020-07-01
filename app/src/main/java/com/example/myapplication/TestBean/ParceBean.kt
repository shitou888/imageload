package com.example.myapplication.TestBean

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ParceBean(var name: String = "") : Parcelable