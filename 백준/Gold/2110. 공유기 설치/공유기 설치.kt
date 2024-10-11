import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    // N: 첫째 줄에 집의 개수, C: 공유기의 개수(2 ≤ C ≤ N)
    val (N: Int, C: Int) = br.readLine()
        .split(" ")
        .map { it.toInt() }

    // 집의 좌표
    val coordinates: List<Int> = buildList {
        repeat(N) {
            this += br.readLine().toInt()
        }
    }.sorted()

    BufferedWriter(OutputStreamWriter(System.out)).use { bw: BufferedWriter ->
        val result: Int = Solution().solution(C, coordinates)

        bw.write("$result")
    }
}

/*
테스트 값들
5 4
1
2
8
4
9
*/
class Solution {
    fun solution(
        C: Int,
        coordinates: List<Int>
    ): Int {
        var result = 0

        var (start: Int, end: Int) = 0 to coordinates.last()

        while (start <= end) {
            val space: Int = (start + end) / 2

            var prevHouse: Int = coordinates[0] // 첫번째 집
            var cnt = 1 // 첫번째 집부터 설치 후 간격 계산하기

            coordinates.forEach {
                if ((it - prevHouse) >= space) {
                    cnt++
                    prevHouse = it
                }
            }

            if (cnt < C) {
                end = space - 1
            } else {
                result = space
                start = space + 1
            }
        }

        return result
    }
}