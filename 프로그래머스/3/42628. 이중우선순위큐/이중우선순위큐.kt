import java.util.PriorityQueue

class Solution {
    fun solution(operations: Array<String>): IntArray {
        val answer = IntArray(size = 2)

        val mainHeap = PriorityQueue<Int>(reverseOrder())
        val subHeap = PriorityQueue<Int>()

        for (i: Int in operations.indices) {
            val split: List<String> = operations[i].split(" ")

            when (split[0]) {
                // 삽입
                "I" -> {
                    mainHeap.add(split[1].toInt())
                }

                // 제거
                "D" -> when (split[1]) {
                    // 최대값을 제거한다
                    "1" -> {
                        if (mainHeap.isNotEmpty()) {
                            mainHeap.poll()
                        }
                    }

                    // 최소값을 제거한다.
                    "-1" -> {
                        while (mainHeap.isNotEmpty()) {
                            subHeap.add(mainHeap.poll())
                        }

                        if (subHeap.isNotEmpty()) {
                            subHeap.poll()
                        }

                        // 힙 갱신
                        while (subHeap.isNotEmpty()) {
                            mainHeap.add(subHeap.poll())
                        }
                    }
                }
            }
        }

        if (mainHeap.isEmpty()) {
            answer[0] = 0
            answer[1] = 0
        } else {
            answer[0] = mainHeap.peek()

            while (mainHeap.isNotEmpty()) {
                subHeap.add(mainHeap.poll())
            }

            if (subHeap.isNotEmpty()) {
                answer[1] = subHeap.peek()
            }
        }

        return answer
    }
}