import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/*
테스트 값들
4 12
802
743
457
539

2 10
200
400

3 100
555
324
178

1 1
2147483647
*/
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    // K: 가지고 있는 랜선의 개수, N: 필요한 랜선의 개수
    val (K: Int, N: Int) = br.readLine()
        .split(" ")
        .map { it.toInt() }

    // 가지고 있는 랜선들의 길이 리스트
    val lines: List<Int> = buildList {
        repeat(K) {
            this += br.readLine().toInt()
        }
    }

    BufferedWriter(OutputStreamWriter(System.out)).use { bw: BufferedWriter ->
        val result: Int = Solution().solution(N, lines)

        bw.write("$result")
    }
}

class Solution {
    fun solution(
        N: Int,
        lines: List<Int>
    ): Int {
        var result = 0

        var (start: Long, end: Long) = 1L to lines.max().toLong()

        while (start <= end) {
            val mid: Int = ((start + end) / 2).toInt()

            // mid가 0이 되면 멈추기
            if(mid == 0) break

            val cnt: Int = lines.fold(0) { total, len ->
                total + len / mid
            }

            if (cnt < N) {
                end = (mid - 1).toLong()
            } else {
                result = mid
                start = (mid + 1).toLong()
            }
        }

        return result
    }
}