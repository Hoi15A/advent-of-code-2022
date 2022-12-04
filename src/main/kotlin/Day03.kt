fun main() {
    val lines = readFile("Day03", false)
    val day = Day03(lines)

    println("Solution part 1: ${day.part1()}")
    println("Solution part 2: ${day.part2()}")
}

class Day03(private val lines: List<String>) : Day {

    private class Rucksack(private val contents: String) {
        private val firstHalf: String = contents.substring(0, contents.length / 2)
        private val secondHalf: String = contents.substring(contents.length / 2, contents.length)

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

        fun findCommonRucksackItemPriority(otherSacks: List<Rucksack>): Int {
            for (char in this.contents) {
                var otherSacksContainingChar = 0
                for (sack in otherSacks) {
                    if (sack.contents.contains(char)) {
                        otherSacksContainingChar++
                    }
                }
                if (otherSacksContainingChar == otherSacks.size) {
                    // FOUND
                    return mapCharToPriority(char)
                }
            }

            return 0 // NOT FOUND
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
        var total = 0
        val rucksacks = mutableListOf<Rucksack>()
        var i = 0
        for (line in lines) {
            i++
            val rucksack = Rucksack(line)

            if (i == 3) {
                i = 0
                total += rucksack.findCommonRucksackItemPriority(rucksacks)
                rucksacks.clear()
            } else {
                rucksacks.add(rucksack)
            }
        }
        return total
    }

}