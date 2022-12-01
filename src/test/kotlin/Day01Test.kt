import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day01Test {
    @Test
    fun part1() {
        val lines = readFile("Day01", true)
        val day = Day01(lines)

        assertEquals(24000, day.part1())
    }
}