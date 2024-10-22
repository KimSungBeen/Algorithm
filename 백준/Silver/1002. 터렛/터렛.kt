import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs
import kotlin.math.pow

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val T: Int = br.readLine().toInt()

    val xyr: List<List<Int>> = buildList {
        repeat(T) {
            this@buildList += br.readLine()
                .split(" ")
                .map { it.toInt() }
        }
    }



    BufferedWriter(OutputStreamWriter(System.out)).use { bw: BufferedWriter ->
        val result: List<Int> = Solution().solution(xyr)

        result.forEach {
            bw.write("$it\n")
        }
    }
}

class Solution {
    fun solution(xyr: List<List<Int>>): List<Int> {
        val result: List<Int> = buildList {
            xyr.forEach {
                val (x1: Int, y1: Int, r1: Int) = it.subList(0, 3)
                val (x2: Int, y2: Int, r2: Int) = it.subList(3, 6)

                val d = getDistancePow(x1 to y1, x2 to y2)

                when {
                    // 무수히 많음
                    d == 0.toDouble() && r1 == r2 -> this += -1

                    // 만나지 않음
                    d < abs(r1 - r2).toDouble().pow(2.toDouble()) || d > (r1 + r2).toDouble()
                        .pow(2.toDouble()) -> this += 0

                    // 한점에서 만남
                    d == abs(r1 - r2).toDouble().pow(2.toDouble()) || d == (r1 + r2).toDouble()
                        .pow(2.toDouble()) -> this += 1

                    // 두 점에서 만남
                    else -> this += 2
                }
            }
        }

        return result
    }

    private fun getDistancePow(p1: Pair<Int, Int>, p2: Pair<Int, Int>): Double {
        return (p2.first - p1.first).toDouble()
            .pow(2.toDouble()) + (p2.second - p1.second).toDouble().pow(2.toDouble())
    }
}