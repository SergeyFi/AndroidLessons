package com.example.miningmania.source

import com.example.miningmania.source.сomponents.Stack

class Miner(val miningCoeff: Float) {

    private var stack: Stack? = null
    private var coin = 0.0f
    private var coinProgress = 0.0f

    private fun addCoinProgress(value: Float){
        coinProgress += value

        if (coinProgress > 1.0f){
            coinProgress -= 1.0f
        }
    }

    fun removeCoin(value: Float): Float{
        if (value > coin){
            val buf = coin

            coin = 0.0f

            return buf
        }
        else {

            coin -= value

            return value
        }
    }

    fun addStack(stack: Stack){
        this.stack = stack
    }

    fun mine() : Float{

        var mine = 0.0f

        stack?.let {
            mine += it.calculateMiningScore()
        }

        val miningValue = mine * miningCoeff * 0.005f

        coin += miningValue
        addCoinProgress(miningValue)

        return mine * miningCoeff
    }
}