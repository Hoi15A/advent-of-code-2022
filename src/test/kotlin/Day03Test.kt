import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day03Test {
    private val lines = readFile("Day03", true)

    @Test
    fun part1() {
        val day = Day03(lines)

        assertEquals(157, day.part1())
    }

    @Test
    fun part2() {
        val day = Day03(lines)
        assertEquals(70, day.part2())
    }
}