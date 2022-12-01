import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day01Test {
    private val lines = readFile("Day01", true)

    @Test
    fun part1() {
        val day = Day01(lines)

        assertEquals(24000, day.part1())
    }

    @Test
    fun part2() {
        val day = Day01(lines)

        assertEquals(45000, day.part2())
    }
}