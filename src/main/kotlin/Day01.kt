fun main() {
    val lines = readFile("Day01", false)
    val day = Day01(lines)

    println("Solution part 1: ${day.part1()}")
    println("Solution part 2: ${day.part2()}")
}

class Day01(private val lines: List<String>) : Day {

    override fun part1(): Any {
        val elves = getElvesFromInput()
        return elves.maxBy { it.totalCalories }.totalCalories
    }

    override fun part2(): Any {
        val elves = getElvesFromInput()
        return elves.sortedBy { it.totalCalories }.takeLast(3).sumOf { it.totalCalories }
    }

    private fun getElvesFromInput() : List<Elf> {
        val elves = mutableListOf<Elf>()
        val grouped = lines.joinToString(";").split(";;")
        for (elfTxt in grouped) {
            elves.add(Elf(elfTxt))
        }
        return elves
    }

    class Elf(textRep : String) {
        val totalCalories: Int
        init {
            var sum = 0
            for (s in textRep.split(";")) {
                sum += s.toInt()
            }
            totalCalories = sum
        }
    }

}