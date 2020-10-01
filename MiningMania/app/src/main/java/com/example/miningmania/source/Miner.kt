package com.example.miningmania.source

import com.example.miningmania.source.сomponents.Stack

class Miner(val miningCoeff: Float) {

    private var stack: Stack? = null

    fun addStack(stack: Stack){
        this.stack = stack
    }

    fun mine() : Float{

        var mine = 0.0f

        stack?.let {
            mine += it.calculateMiningScore()
        }

        return mine * miningCoeff
    }
}