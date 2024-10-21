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
        val result: Pair<Int, List<Int>> = Solution().solution(A)

        bw.write("${result.first}\n")
        bw.write(result.second.joinToString(" "))
    }
}

class Solution {
    fun solution(A: List<Int>): Pair<Int, List<Int>> {
        val lis = mutableListOf<Int>()

        // A리스트를 순회할 때 해당 원소의 수열 내의 index
        val indexList = mutableListOf<Int>()

        // indexList에 기록될 index
        var index = 0

        A.forEach { i: Int ->
            var (start: Int, end: Int) = 0 to lis.lastIndex

            var insertIndex = end + 1

            while (start <= end) {
                val mid: Int = (start + end) / 2

                if (lis[mid] >= i) {
                    insertIndex = mid
                    end = mid - 1
                } else {
                    start = mid + 1
                }
            }

            if (insertIndex < lis.size) {
                lis[insertIndex] = i
                indexList.add(insertIndex)
            } else {
                lis.add(i)
                indexList.add(index++)
            }
        }

        // lis 가 알맞는 수열로 재조정 될 때 재조정 되는 index의 순서 (뒤부터 시작)
        var order: Int = lis.lastIndex

        for (i in indexList.lastIndex downTo 0) {
            if (indexList[i] == order) {
                lis[order] = A[i]
                order--
            }
        }

        return lis.size to lis.toList()
    }
}