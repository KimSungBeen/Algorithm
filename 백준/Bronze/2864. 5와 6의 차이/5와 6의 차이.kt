fun main() {
    Solution2864().solve()
}

class Solution2864 {

    fun solve() {
        val numbers = readLine()?.split(" ")!!

        print("${getMinimum(numbers)} ${getMaximum(numbers)}")
    }

    private fun getMaximum(numbers: List<String>):Int {
        val maxNumbers = numbers.map { it.replace("5", "6") }
        return maxNumbers[0].toInt() + maxNumbers[1].toInt()
    }

    private fun getMinimum(numbers: List<String>):Int {
        val maxNumbers = numbers.map { it.replace("6", "5") }
        return maxNumbers[0].toInt() + maxNumbers[1].toInt()
    }
}