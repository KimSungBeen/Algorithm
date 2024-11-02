import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    BufferedWriter(OutputStreamWriter(System.out)).use { bw: BufferedWriter ->
        val result: Double = br.readLine()
            .split(" ")
            .map { it.toDouble() }
            .reduce { acc, i -> acc / i }

        bw.write("$result")
    }
}