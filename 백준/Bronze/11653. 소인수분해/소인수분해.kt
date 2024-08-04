import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val inputValue: Int = Integer.parseInt(br.readLine())
    var calcValue = inputValue
    val result = StringBuilder()
    var cnt = 2
    while (calcValue > 1) {
        if (calcValue % cnt == 0) {

            result.append("$cnt\n")

            calcValue /= cnt
        } else {
            cnt++
        }
    }

    bw.write("$result")

    bw.flush()
    bw.close()

    br.close()
}
