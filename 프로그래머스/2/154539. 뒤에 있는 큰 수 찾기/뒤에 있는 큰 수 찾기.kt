import java.util.Stack

class Solution {
    fun solution(numbers: IntArray): IntArray {
        val answer = IntArray(numbers.size)

        val s = Stack<Int>()

        // 배열에서 마지막을 제외하고 반복한다.
        for (i in numbers.lastIndex downTo 0) {
            answer[i] = -1 // 초기화

            while (!s.isEmpty()) {
                if (numbers[i] < s.peek()) {
                    answer[i] = s.peek()
                    break
                } else {
                    s.pop()
                }
            }

            s.push(numbers[i])
        }

        return answer
    }
}