import kotlin.math.min

class Solution {
    fun solution(
        keymap: Array<String>,
        targets: Array<String>
    ): IntArray {
        val answer = IntArray(size = targets.size)

        val minHitCountMap = mutableMapOf<Char, Int?>()

        keymap.forEach { key: String ->
            key.forEachIndexed { index: Int, alphabet: Char ->
                val oldCount: Int? = minHitCountMap[alphabet]
                val newCount: Int = index + 1

                minHitCountMap[alphabet] = if (oldCount != null) {
                    min(oldCount, newCount)
                } else {
                    newCount
                }
            }
        }

        targets.forEachIndexed { index: Int, word: String ->
            var sum = 0
            for (c: Char in word) {
                val count: Int? = minHitCountMap[c]

                if (count != null) {
                    sum += count
                } else {
                    sum = -1
                    break
                }
            }

            answer[index] = sum
        }

        return answer
    }
}