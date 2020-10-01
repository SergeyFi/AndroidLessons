package com.example.miningmania.source

import android.widget.TextView

class UIUpdater(private val hashText: TextView, private val moneyText: TextView) {

    private val hashPrefix = " h\\s"
    private val moneyPrefix = " $"

    fun updateHashSpeed(speed: Float){
        hashText.text = speed.toString() + hashPrefix
    }

    fun updateMoney(money: Float)
    {
        moneyText.text = money.toString() + moneyPrefix
    }
}