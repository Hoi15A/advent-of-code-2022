import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day05Test {
    private val lines = readFile("Day05", true)

    @Test
    fun part1() {
        val day = Day05(lines)

        assertEquals("CMZ", day.part1())
    }

    @Test
    fun part2() {

    }
}