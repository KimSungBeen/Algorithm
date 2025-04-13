import java.util.PriorityQueue

class Solution {
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        // 인접 리스트 만들기
        val graph = Array(size = N + 1) { mutableListOf<Pair<Int, Int>>() }

        for ((a, b, c) in road) {
            graph[a].add(b to c)
            graph[b].add(a to c)
        }

        val distance = IntArray(size = N + 1) { Int.MAX_VALUE }
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

        distance[1] = 0
        pq.add(1 to 0)

        while (pq.isNotEmpty()) {
            val (now, cost) = pq.poll()!!

            if (distance[now] < cost) continue

            for ((next, nextCost) in graph[now]) {
                if (cost + nextCost < distance[next]) {
                    distance[next] = cost + nextCost
                    pq.add(next to cost + nextCost)
                }
            }
        }

        return distance.count { it <= k }
    }
}