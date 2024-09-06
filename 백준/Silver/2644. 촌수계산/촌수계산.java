import java.util.LinkedList;
import java.util.Queue;
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
            int n = Integer.parseInt(br.readLine());

            String[] targets = br.readLine().split(" ");
            int targetPeople1 = Integer.parseInt(targets[0]);
            int targetPeople2 = Integer.parseInt(targets[1]);

            int m = Integer.parseInt(br.readLine());

            int[][] relations = new int[m][2];

            for (int i = 0; i < relations.length; i++) {
                String[] r = br.readLine().split(" ");
                relations[i][0] = Integer.parseInt(r[0]);
                relations[i][1] = Integer.parseInt(r[1]);
            }

            Solution s = new Solution();

            int result = s.solution(n, relations, targetPeople1, targetPeople2);

            bw.write(String.valueOf(result));

            bw.flush();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {
    // 관계 배열에서 targetPeople1, targetPeople2간의 최단 경로를 찾는것과 같으므로 bfs로 접근한다.
    public int solution(int n, int[][] relations, int targetPeople1, int targetPeople2) {
        boolean[] visited = new boolean[relations.length];

        // index: 사람 번호, value: targetPeople1과 촌수
        int[] cnt = new int[n + 1];

        Queue<Integer> q = new LinkedList<>();

        // targetPeople1 과 인접한 번호 추가
        for (int i = 0; i < relations.length; i++) {
            if (relations[i][0] == targetPeople1) {
                q.add(relations[i][1]);
                visited[i] = true;
                cnt[relations[i][1]] = 1;
            } else if (relations[i][1] == targetPeople1) {
                q.add(relations[i][0]);
                visited[i] = true;
                cnt[relations[i][0]] = 1;
            }
        }

        while (!q.isEmpty()) {
            int num = q.poll();

            if (num == targetPeople2) {
                return cnt[num];
            }

            for (int i = 0; i < relations.length; i++) {
                if (visited[i]) continue;

                if (relations[i][0] == num) {
                    q.add(relations[i][1]);
                    visited[i] = true;
                    cnt[relations[i][1]] = cnt[num] + 1;
                } else if (relations[i][1] == num) {
                    q.add(relations[i][0]);
                    visited[i] = true;
                    cnt[relations[i][0]] = cnt[num] + 1;
                }
            }
        }

        return -1;
    }
}
