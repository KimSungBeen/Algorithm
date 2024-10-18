import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    // N: 수열 A의 크기(1 ≤ N ≤ 1,000,000)
    val N: Int = br.readLine().toInt()

    // 수열 A
    val A: List<Int> = br.readLine()
        .split(" ")
        .map { it.toInt() }

    BufferedWriter(OutputStreamWriter(System.out)).use { bw: BufferedWriter ->
        val result: Pair<Int, List<Int>> = Solution().solution(A)

        bw.write("${result.first}\n")
        bw.write(result.second.joinToString(" "))
    }
}

class Solution {
    fun solution(A: List<Int>): Pair<Int, List<Int>> {
        // dp 배열, 원소는 해당 인덱스 까지의 가장 긴 증가하는 부분 수열 사이즈
        val dp: Array<Int> = Array(A.size) { it }

        A.forEachIndexed { i: Int, num: Int ->
            dp[i] = 1

            for (j in 0 until i) {
                if (A[i] > A[j]) {
                    dp[i] = max(dp[i], dp[j] + 1)
                }
            }
        }

        val maxSize: Int = dp.max()

        val lis: Array<Int> = Array(maxSize) { 0 }

        var dpNum = maxSize
        for (i in dp.lastIndex downTo 0) {
            if (dp[i] == dpNum) {
                lis[dpNum - 1] = A[i]
                dpNum--
            }
        }

        return maxSize to lis.toList()
    }
}