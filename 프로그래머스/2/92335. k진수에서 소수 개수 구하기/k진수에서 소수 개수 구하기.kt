import java.util.Stack
import kotlin.math.sqrt

class Solution {
    fun solution(n: Int, k: Int): Int {
        var answer = 0

        val numString: String = if (k == 10) {
            n.toLong().toString()
        } else {
            n.translateTo(k)
        }

        val allNum: List<String> = buildList {
            if ("0" !in numString) {
                add(numString)
            } else {
                addAll(
                    numString
                        .split("0")
                        .filter { it.isNotBlank() }
                )
            }
        }

        allNum.forEach {
            if (it.toLong().isPrime()) {
                answer++
            }
        }

        return answer
    }

    /** 10진수를 [k]진수 문자열로 변환 */
    private fun Int.translateTo(k: Int): String {
        var target: Int = this
        val stack = Stack<Int>()

        while (target >= k) {
            val quotient: Int = target / k // 몫
            val remainder: Int = target % k // 나머지

            stack.push(remainder)
            target = quotient
        }

        stack.push(target)

        val split: List<String> = buildList {
            while (!stack.isEmpty()) {
                this += "${stack.pop()}"
            }
        }

        return split.joinToString("")
    }

    private fun Long.isPrime(): Boolean {
        if (this < 2) return false
        if (this == 2L) return true  // 2는 유일한 짝수 소수

        if (this % 2 == 0L) return false  // 짝수 거르기

        val sqrt = kotlin.math.sqrt(this.toDouble()).toLong()
        for (i in 3..sqrt step 2) {  // 홀수만 검사
            if (this % i == 0L) return false
        }

        return true
    }
}