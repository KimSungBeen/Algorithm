import java.util.Stack;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;

        // 전체 wire가 한번씩 끊어진 경우 순회
        for (int i = 0; i < wires.length; i++) {
            int[] cutWire = wires[i]; // 끊어진 wire

            // wire가 끊어진 송전탑과 연결된 송전탑을 찾아 stack에 넣을 때,
            // 중복 방지를 위한 플래그
            boolean[] linked = new boolean[n + 1];
            Stack<Integer> s = new Stack<>();

            // 첫 순회 송전탑 push
            s.push(cutWire[0]);
            linked[cutWire[0]] = true;

            int cnt = 0;

            while (!s.isEmpty()) {
                int top = s.pop();
                cnt++;

                // 끊어진 wire를 제외한 모든 wire 순회하며
                // 첫 순회 송전탑과 연결된 송전탑을 stack에 추가
                for (int j = 0; j < wires.length; j++) {
                    if (i == j) continue;

                    if (wires[j][0] == top && !linked[wires[j][1]]) {
                        s.push(wires[j][1]);
                        linked[wires[j][1]] = true;
                    } else if (wires[j][1] == top && !linked[wires[j][0]]) {
                        s.push(wires[j][0]);
                        linked[wires[j][0]] = true;
                    }
                }
            }

            int group1 = cnt;
            int group2 = Math.abs(n - cnt);

            answer = Math.min(answer, Math.abs(group1 - group2));
        }

        return answer;
    }
}
