import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int T = Integer.parseInt(br.readLine());
            long[] cases = new long[T];

            for (int i = 0; i < cases.length; i++) {
                cases[i] = Long.parseLong(br.readLine());
            }

            Solution s = new Solution();
            long[] answers = s.solution(cases);

            for (int i = 0; i < answers.length; i++) {
                bw.write(String.valueOf(answers[i]));

                if (i < answers.length - 1) {
                    bw.write("\n");
                }
            }

            bw.flush();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    public long[] solution(long[] cases) {
        long[] resultArr = new long[cases.length];

        for (int i = 0; i < cases.length; i++) {
            long N = cases[i];
            long start = 1, end = (long) Math.sqrt((2*N-1));

            while (start < end) {
                long mid = (start + end) / 2 + 1;

                if ((mid * (mid + 1)) / 2 > N) {
                    end = mid - 1;
                } else {
                    start = mid;
                }
            }

            resultArr[i] = start;
        }

        return resultArr;
    }
}
