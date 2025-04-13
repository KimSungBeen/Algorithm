import java.util.LinkedList
import java.util.Queue

class Solution {
    fun solution(maps: Array<String>): IntArray {
        val answer = mutableListOf<Int>()

        val m = maps.size
        val n = maps.first().length

        // 방문 배열
        val vis = Array(m) { BooleanArray(n) }

        // 우, 좌, 상, 하
        val dx = intArrayOf(1, -1, 0, 0)
        val dy = intArrayOf(0, 0, 1, -1)

        val q: Queue<Pair<Int, Int>> = LinkedList()

        for (i: Int in 0 until m) {
            for (j: Int in 0 until n) {

                if (maps[i][j] == 'X' || vis[i][j]) continue

                q.add(i to j)
                vis[i][j] = true
                answer.add(0)

                while (q.isNotEmpty()) {
                    val (x, y) = q.poll()!!
                    answer[answer.lastIndex] += maps[x][y].digitToInt()

                    for (k: Int in 0 until 4) {
                        val (nx, ny) = x + dx[k] to y + dy[k]

                        if (nx in 0 until m && ny in 0 until n && maps[nx][ny] != 'X' && !vis[nx][ny]) {
                            q.add(nx to ny)
                            vis[nx][ny] = true
                        }
                    }
                }
            }
        }

        return if (answer.isNotEmpty()) {
            answer.sorted().toIntArray()
        } else {
            intArrayOf(-1)
        }
    }
}