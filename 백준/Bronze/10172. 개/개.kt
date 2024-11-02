import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    BufferedWriter(OutputStreamWriter(System.out)).use { bw: BufferedWriter ->
        bw.write(
            "|\\_/|\n" +
                "|q p|   /}\n" +
                "( 0 )\"\"\"\\\n" +
                "|\"^\"`    |\n" +
                "||_/=\\\\__|"
        )
    }
}