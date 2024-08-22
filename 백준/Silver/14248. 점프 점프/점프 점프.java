import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution();
    }
}

class Solution {
    int[] nums;
    boolean[] visited;

    public void solution() {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // nums 배열의 사이즈
        int size;

        // nums 배열에서 시작할 포지션
        int startPosition;

        try {
            size = Integer.parseInt(br.readLine());
            this.nums = new int[size];
            this.visited = new boolean[size];
            String[] _nums = br.readLine().split(" ");

            for (int i = 0; i < size; i++) {
                this.nums[i] = Integer.parseInt(_nums[i]);
                this.visited[i] = false;
            }

            // nums 에서 시작할 포지션 초기화
            startPosition = Integer.parseInt(br.readLine()) - 1;

            int answer = dfs(startPosition, 0);

            bw.write(String.valueOf(answer));
            bw.flush();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int dfs(int position, int cnt) {
        this.visited[position] = true;
        cnt++;

        int num = this.nums[position];

        // 왼쪽으로 이동
        if (position >= num && !this.visited[position - num]) {
            cnt = dfs(position - num, cnt);
        }

        // 오른쪽으로 이동
        if (position + num < nums.length && !this.visited[position + num]) {
            cnt = dfs(position + num, cnt);
        }

        return cnt;
    }
}
