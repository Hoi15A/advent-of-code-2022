fun main() {
    val input = readFile("Day06", false)
    val day = Day06(input)

    println("Solution part 1: ${day.part1()}")
    println("Solution part 2: ${day.part2()}")
}

class Day06(private val lines: List<String>) : Day {

    private fun hasDuplicateChars(str: String): Boolean {
        val chars = mutableSetOf<Char>()
        str.forEach {
            if (chars.contains(it)) return true
            chars.add(it)
        }
        return false
    }

    private fun processDataStream(data: String, seqLength: Int): Int {
        for (i in 0..data.length - seqLength) {
            val seq = data.substring(i, i + seqLength)
            if (!hasDuplicateChars(seq)) return i + seqLength
        }

        return 0
    }

    override fun part1(): Any {
        val data = lines[0]
        return processDataStream(data, 4)
    }

    override fun part2(): Any {
        val data = lines[0]
        return processDataStream(data, 14)
    }
}