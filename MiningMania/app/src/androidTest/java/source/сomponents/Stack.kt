package source.сomponents

class Stack(private val size: Int) {

    private val boards = Array<BoardComponent?>(size){null}

    fun addBoard(board: BoardComponent, index: Int) : BoardComponent? {

        if (index < size){

            val buf = boards[index]

            boards[index] = board

            return buf
        }

        return null
    }

    fun getRequiredPower() : Float{
        var requiredPower = 0.0f

        for (board in boards){
            if (board != null){
                requiredPower += board.calculateTDP()
            }
        }

        return requiredPower
    }

    fun getMiningScore(): Float {
        var score = 0.0f

        for (board in boards){
            if (board != null){
                score += board.calculateMiningScore()
            }
        }

        return score
    }

}