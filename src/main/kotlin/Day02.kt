fun main() {
    val lines = readFile("Day02", false)
    val day = Day02(lines)

    println("Solution part 1: ${day.part1()}")
    println("Solution part 2: ${day.part2()}")
}

class Day02(private val lines: List<String>) : Day {

    enum class RPS(val opTxt: String, val meTxt: String, val value: Int) {
        ROCK("A", "X", 1),
        PAPER("B", "Y", 2),
        SCISSORS("C", "Z", 3);
    }

    private fun evaluateRPSRound(opponentTxt: String, myTxt: String): Int {
        var bonusPoints = 0
        var opponent: RPS? = null
        var me: RPS? = null
        for (value in RPS.values()) {
            if (value.opTxt == opponentTxt) opponent = value
            if (value.meTxt == myTxt) me = value
        }

        // DRAW
        if (me == opponent) {
            bonusPoints = 3
        }
        // WIN
        if (
            me == RPS.ROCK && opponent == RPS.SCISSORS ||
            me == RPS.PAPER && opponent == RPS.ROCK ||
            me == RPS.SCISSORS && opponent == RPS.PAPER
        ) {
            bonusPoints = 6
        }


        return me!!.value + bonusPoints
    }

    override fun part1(): Any {
        var score = 0

        for (line in lines) {
            val tmp = line.split(" ")
            val opponentMove = tmp[0]
            val myMove = tmp[1]
            score += evaluateRPSRound(opponentMove, myMove)
        }

        return score
    }

    override fun part2(): Any {
        TODO("Not implemented")
    }

}