import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day06Test {

    private val part1Examples = mutableListOf(
        Pair("bvwbjplbgvbhsrlpgdmjqwftvncz", 5),
        Pair("nppdvjthqldpwncqszvftbrmjlhg", 6),
        Pair("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 10),
        Pair("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 11)
    )

    private val part2Examples = mutableListOf(
        Pair("mjqjpqmgbljsphdztnvjfqwrcgsmlb", 19),
        Pair("bvwbjplbgvbhsrlpgdmjqwftvncz", 23),
        Pair("nppdvjthqldpwncqszvftbrmjlhg", 23),
        Pair("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 29),
        Pair("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 26)
    )

    @Test
    fun part1() {
        for (example in part1Examples) {
            val day = Day06(mutableListOf(example.first))
            assertEquals(example.second, day.part1())
        }
    }

    @Test
    fun part2() {
        for (example in part2Examples) {
            val day = Day06(mutableListOf(example.first))
            assertEquals(example.second, day.part2())
        }
    }
}