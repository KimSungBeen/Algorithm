import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.main();
    }
}

class Solution {
    /** 부등호 개수 */
    int k;

    /** 부등호 배열 */
    String[] inequalitySigns;

    /** 숫자 사용 여부 0 ~ 9 */
    boolean[] used;

    /** 답이 될 수 있는 리스트 */
    List<String> answers = new ArrayList<>();

    void main() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            // 입력을 받는다
            this.k = Integer.parseInt(br.readLine());
            this.inequalitySigns = br.readLine().split(" ");
            this.used = new boolean[10];

            dfs(0, new StringBuilder());

            Collections.sort(this.answers);

            bw.write(this.answers.get(this.answers.size() - 1));
            bw.write("\n");
            bw.write(this.answers.get(0));

            bw.flush();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void dfs(int index, StringBuilder num) {
        // 반복 횟수가 k + 1번째라면 등식이 완성된 것이므로 답 리스트에 추가후 함수를 리턴한다.
        if (index == this.k + 1) {
            this.answers.add(num.toString());
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (this.used[i]) continue;

            // 첫번째 숫자는 무조건 추가,
            // 마지막으로 추가된 숫자와 새로 추가될 숫자의 조건연산이 참이면 StringBuilder에 값 추가
            // 재귀호출에서 돌아올 때 백트래킹 처리
            if (index == 0 || check(num.charAt(num.length() - 1) - '0', i, this.inequalitySigns[index - 1])) {
                num.append(i);
                this.used[i] = true;
                dfs(index + 1, num);
                this.used[i] = false;
                num.deleteCharAt(num.length() - 1); // 마지막에 추가된 숫자를 삭제
            }
        }
    }

    private boolean check(int a, int b, String sign) {
        return sign.equals("<") ? a < b : a > b;
    }
}
