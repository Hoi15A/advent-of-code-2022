import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day04Test {
    private val lines = readFile("Day04", true)

    @Test
    fun part1() {
        val day = Day04(lines)

        assertEquals(2, day.part1())
    }

    @Test
    fun part2() {
        val day = Day04(lines)
        assertEquals(4, day.part2())
    }
}