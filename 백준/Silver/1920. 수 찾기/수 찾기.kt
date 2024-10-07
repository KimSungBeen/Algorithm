import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val N: Int = br.readLine()
        .toInt()

    val A: List<Int> = br.readLine()
        .split(" ")
        .map { it.toInt() }
        .sorted()

    val M: Int = br.readLine()
        .toInt()

    val targets: List<Int> = br.readLine()
        .split(" ")
        .map { it.toInt() }

    BufferedWriter(OutputStreamWriter(System.out)).use { bw: BufferedWriter ->
        val result: String = Solution().solution(A, targets)
            .joinToString("\n")

        bw.write(result)
    }
}

class Solution {
    fun solution(
        A: List<Int>,
        targets: List<Int>
    ): List<Int> = buildList {
        targets.forEach { target: Int ->
            var (startIndex: Int, lastIndex: Int, result: Int) = listOf(0, A.lastIndex, 0)

            while (startIndex <= lastIndex) {
                val mid: Int = (startIndex + lastIndex) / 2

                if (target > A[mid]) {
                    startIndex = mid + 1
                } else if (target == A[mid]) {
                    result = 1
                    break
                } else {
                    lastIndex = mid - 1
                }
            }

            this += result
        }
    }
}