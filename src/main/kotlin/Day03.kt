fun main() {
    val lines = readFile("Day03", false)
    val day = Day03(lines)

    println("Solution part 1: ${day.part1()}")
    println("Solution part 2: ${day.part2()}")
}

class Day03(private val lines: List<String>) : Day {

    private class Rucksack(contents: String) {
        private val firstHalf: String
        private val secondHalf: String

        init {
            firstHalf = contents.substring(0, contents.length / 2)
            secondHalf = contents.substring(contents.length / 2, contents.length)
        }

        fun findDuplicateItem(): Char? {
            firstHalf.forEach { if (secondHalf.contains(it)) return it }
            return null
        }

        fun findDuplicateItemPriority(): Int {
            val item = findDuplicateItem()!!
            return mapCharToPriority(item)
        }

        private fun mapCharToPriority(char: Char): Int {
            return if (char.isLowerCase()) {
                char.code - 96
            } else {
                char.code - 38
            }
        }
    }

    override fun part1(): Any {
        var total = 0
        for (line in lines) {
            val rucksack = Rucksack(line)
            total += rucksack.findDuplicateItemPriority()
        }
        return total
    }

    override fun part2(): Any {
        TODO()
    }

}