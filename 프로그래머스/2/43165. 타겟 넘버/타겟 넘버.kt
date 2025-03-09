class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        return dfs(numbers, target, 0, 0, 0)
    }

    private fun dfs(numbers: IntArray, target: Int, index: Int, value: Int, cnt: Int): Int {
        var _cnt: Int = cnt

        if (index == numbers.size) {
            if (value == target) {
                _cnt++
            }
        } else {
            // 더하기
            _cnt = dfs(numbers, target, index + 1, value + numbers[index], _cnt)

            //빼기
            _cnt = dfs(numbers, target, index + 1, value - numbers[index], _cnt)
        }

        return _cnt
    }
}