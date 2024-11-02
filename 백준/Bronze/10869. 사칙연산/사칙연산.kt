import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    BufferedWriter(OutputStreamWriter(System.out)).use { bw: BufferedWriter ->
        val nums: List<Int> = br.readLine()
            .split(" ")
            .map { it.toInt() }


        bw.write("${nums.sumOf { it }}\n")
        bw.write("${nums.reduce { acc, i -> acc - i }}\n")
        bw.write("${nums.reduce { acc, i -> acc * i }}\n")
        bw.write("${nums.reduce { acc, i -> acc / i }}\n")
        bw.write("${nums.reduce { acc, i -> acc % i }}")
    }
}