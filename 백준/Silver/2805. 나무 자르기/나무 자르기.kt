import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val NM: List<Int> = br.readLine()
        .split(" ")
        .map { it.toInt() }

    // 나무들의 높이
    val heights: List<Int> = br.readLine()
        .split(" ")
        .map { it.toInt() }

    BufferedWriter(OutputStreamWriter(System.out)).use {
        val maxCutHeight: Int = Solution().solution(
            NM[1], // 필요한 나무 높이(M)
            heights
        )

        it.write("$maxCutHeight")
    }
}

class Solution {
    fun solution(
        M: Int,
        heights: List<Int>
    ): Int {
        var (start: Int, end: Int, result: Int) = listOf(0, heights.maxOrNull() ?: 0, 0)

        while (start <= end) {
            val mid: Int = (start + end) / 2

            var sum: Long = 0
            heights.forEach { h: Int ->
                if (h > mid) {
                    sum += h - mid
                }
            }

            if (sum < M) {
                end = mid - 1
            } else {
                result = mid
                start = mid + 1
            }
        }

        return result
    }
}
