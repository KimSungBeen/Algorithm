import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    // N: 지방의 수(3 이상 10,000 이하)
    val N: Int = br.readLine().toInt()

    // 각 지방의 예산(1 이상 100,000 이하)
    val budgets: List<Int> = br.readLine()
        .split(" ")
        .map { it.toInt() }

    // 총 예산을 (N 이상 1,000,000,000 이하)
    val M: Int = br.readLine().toInt()

    BufferedWriter(OutputStreamWriter(System.out)).use { bw: BufferedWriter ->
        val result: Int = Solution().solution(M, budgets)

        bw.write("$result")
    }
}

/*
테스트 값들
4
120 110 140 150
485

5
70 80 30 40 100
450
*/
class Solution {
    fun solution(
        M: Int,
        budgets: List<Int>
    ): Int {
        var result = 0
        var (start: Int, end: Int) = 1 to budgets.max()

        while (start <= end) {
            // 상한액
            val max: Int = (start + end) / 2

            // 사용한 예산 합
            val sum: Int = budgets.fold(M) { total: Int, budget: Int ->
                total - if (budget < max) {
                    budget
                } else {
                    max
                }
            }

            if (sum >= 0) {
                result = max
                start = max + 1
            } else {
                end = max - 1
            }
        }

        return result
    }
}
