import java.util.Stack

fun main() {
    val input = readFile("Day05", false)
    val day = Day05(input)

    println("Solution part 1: ${day.part1()}")
    println("Solution part 2: ${day.part2()}")
}

class Day05(private val lines: List<String>) : Day {

    private val towers = mutableListOf<Stack<Char>>()
    private val stackTextRep = mutableListOf<String>()
    private val instructions = mutableListOf<String>()

    init {
        prepInput()
    }

    private fun prepInput() {
        var isStackText = true
        for (line in lines) {
            if (isStackText) {
                if (line != "") {
                    stackTextRep.add(line)
                } else {
                    isStackText = false
                }
            } else {
                instructions.add(line)
            }
        }
        stackTextRep.reverse()
        parseStackText()
    }

    private fun parseStackText() {
        val labels = stackTextRep.removeFirst().replace(" ", "")
        val towerCount = labels.length

        for (i in 1..towerCount) towers.add(Stack())

        for (line in stackTextRep) {
            val txt = line
                .replace("    ", "  _ ") // 4 empty spaces in a line indicates a missing box so we add a marker
                .replace(Regex("[ \\[\\]]"), "") // remove all useless information
                .padEnd(towerCount, '_') // intellij keeps stripping the end of lines in input so take that into account and pad the string with empty boxes
            for ((j, box) in txt.withIndex()) {
                if (box == '_') continue // '_' is an empty space
                towers[j].push(box)
            }
        }
    }

    data class Instruction (val amount: Int, val start: Int, val end: Int)

    private fun parseInstruction(str: String): Instruction {
        val lst = str.split(" ")
        return Instruction(lst[1].toInt(), lst[3].toInt() - 1, lst[5].toInt() - 1)
    }

    private fun getTowersCopy(): List<Stack<Char>> {
        val lst = mutableListOf<Stack<Char>>()
        towers.forEach { lst.add(it.clone() as Stack<Char>) }
        return lst
    }

    override fun part1(): Any {
        val towersCopy = getTowersCopy()
        instructions.forEach {
            val inst = parseInstruction(it)
            for (i in 1..inst.amount) {
                towersCopy[inst.end].push(towersCopy[inst.start].pop())
            }

        }
        var out = ""
        for (tower in towersCopy) {
            out += tower.peek()
        }
        return out
    }

    override fun part2(): Any {
        val towersCopy = getTowersCopy()
        instructions.forEach {
            val inst = parseInstruction(it)
            val tmp = mutableListOf<Char>()
            for (i in 1..inst.amount) {
                tmp.add(towersCopy[inst.start].pop())
            }
            tmp.reverse()
            tmp.forEach { c -> towersCopy[inst.end].push(c) }
        }
        var out = ""
        for (tower in towersCopy) {
            out += tower.peek()
        }
        return out
    }

}