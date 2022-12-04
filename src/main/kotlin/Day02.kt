fun main() {
    val lines = readFile("Day02", false)
    val day = Day03(lines)

    println("Solution part 1: ${day.part1()}")
    println("Solution part 2: ${day.part2()}")
}

class Day02(private val lines: List<String>) : Day {

    enum class RPS(val opTxt: String, val meTxt: String, val value: Int) {
        ROCK("A", "X", 1),
        PAPER("B", "Y", 2),
        SCISSORS("C", "Z", 3);
    }

    private fun evaluateRPSRound(opponent: RPS, me: RPS): Int {
        var bonusPoints = 0

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

        return me.value + bonusPoints
    }

    private fun mapStrToRPS(str: String): RPS? {
        for (value in RPS.values()) {
            if (value.opTxt == str || value.meTxt == str) return value
        }
        return null
    }

    override fun part1(): Any {
        var score = 0

        for (line in lines) {
            val tmp = line.split(" ")

            val opponent = mapStrToRPS(tmp[0])!!
            val me = mapStrToRPS(tmp[1])!!

            score += evaluateRPSRound(opponent, me)
        }

        return score
    }

    override fun part2(): Any {
        var score = 0

        for (line in lines) {
            val tmp = line.split(" ")

            val opponent = mapStrToRPS(tmp[0])!!

            val me = when (tmp[1]) {
                // Lose
                "X" -> when (opponent) {
                    RPS.ROCK -> RPS.SCISSORS
                    RPS.PAPER -> RPS.ROCK
                    RPS.SCISSORS -> RPS.PAPER
                }
                // Draw
                "Y" -> opponent
                // Win
                "Z" -> when (opponent) {
                    RPS.ROCK -> RPS.PAPER
                    RPS.PAPER -> RPS.SCISSORS
                    RPS.SCISSORS -> RPS.ROCK
                }
                else -> throw IllegalStateException("should not happen lmao")
            }

            score += evaluateRPSRound(opponent, me)
        }

        return score
    }

}