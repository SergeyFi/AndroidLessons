package com.example.miningmania.source.сomponents

class Stack(private val boardCount: Int, private val powerSupplyCount: Int) {

    private val boards = Array<BoardComponent?>(boardCount){null}
    private val powerSupply = Array<PowerSupply?>(boardCount){null}

    private var requiredPower = 0.0f
    private var miningScore = 0.0f
    private var currentPower = 0.0f

    fun addBoard(board: BoardComponent, index: Int) : BoardComponent? {

        if (index < boardCount){

            val buf = boards[index]

            boards[index] = board

            calculateRequiredPower()
            calculateMiningScore()

            return buf
        }

        return null
    }

    fun addPowerSupply(power: PowerSupply, index: Int): PowerSupply? {

        if (index < boardCount){

            val buf = powerSupply[index]

            powerSupply[index] = power

            calculateCurrentPower()
            calculateMiningScore()

            return buf
        }

        return null
    }

    fun calculateRequiredPower(): Float {

        requiredPower = 0.0f

        for (board in boards){
            if (board != null){
                requiredPower += board.calculateTDP()
            }
        }

        return requiredPower
    }

    fun calculateMiningScore(): Float {
        miningScore = 0.0f

        for (board in boards){
            if (board != null){
                miningScore += board.calculateMiningScore()
            }
        }

        if (calculateCurrentPower() < calculateRequiredPower())
        {
            miningScore = 0.0f

            return miningScore
        }

        return miningScore
    }

    fun calculateCurrentPower(): Float{

        currentPower = 0.0f

        for (supply in powerSupply){
            if (supply!= null){
                currentPower += supply.power
            }
        }

        return currentPower
    }

}