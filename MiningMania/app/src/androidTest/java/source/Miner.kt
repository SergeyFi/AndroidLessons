package source

import source.сomponents.Stack

class Miner(val miningCoeff: Float) {

    private var stack: Stack? = null

    fun addStack(stack: Stack){
        this.stack = stack
    }

    fun mine() : Float{

        var mine = 0.0f

        stack?.let {
            mine += it.getMiningScore()
        }

        return mine * miningCoeff
    }
}