fun main() {
    val lines = readFile("Day04", false)
    val day = Day04(lines)

    println("Solution part 1: ${day.part1()}")
    println("Solution part 2: ${day.part2()}")
}

class Day04(private val lines: List<String>) : Day {

    private fun rangeStrToRange(str: String): IntRange {
        val tmp = str.split("-")
        return IntRange(tmp[0].toInt(), tmp[1].toInt())
    }

    override fun part1(): Any {
        var total = 0
        for (line in lines) {
            val l = line.split(",")
            val range1 = rangeStrToRange(l[0]).toSet()
            val range2 = rangeStrToRange(l[1]).toSet()

            if (range1.containsAll(range2) || range2.containsAll(range1)) {
                total++
            }
        }
        return total
    }

    override fun part2(): Any {
        var total = 0
        for (line in lines) {
            val l = line.split(",")
            val range1 = rangeStrToRange(l[0]).toSet()
            val range2 = rangeStrToRange(l[1]).toSet()

            if (range1.intersect(range2).isNotEmpty()) total++
        }
        return total
    }

}