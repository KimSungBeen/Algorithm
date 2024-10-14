import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    // N: 수열 A의 크기(1 ≤ N ≤ 1,000,000)
    val N: Int = br.readLine().toInt()

    // 수열 A
    val A: List<Int> = br.readLine()
        .split(" ")
        .map { it.toInt() }

    BufferedWriter(OutputStreamWriter(System.out)).use { bw: BufferedWriter ->
        val result: Int = Solution().solution(A)

        bw.write("$result")
    }
}

class Solution {
    fun solution(
        A: List<Int>
    ): Int {
        val lis: MutableList<Int> = mutableListOf()

        // 각 인덱스별 원소가 수열의 첫번 째일 때를 가정하기 위해 리스트를 순회한다.
        A.forEachIndexed { index: Int, num: Int ->
            var (start: Int, end: Int) = 0 to lis.lastIndex
            var insertIndex: Int = end + 1

            while (start <= end) {
                val mid = (start + end) / 2

                if (lis[mid] < num) {
                    start = mid + 1
                } else {
                    insertIndex = mid
                    end = mid - 1
                }
            }

            if (insertIndex < lis.size) {
                lis[insertIndex] = num
            } else {
                lis.add(num)
            }
        }

        return lis.size
    }
}