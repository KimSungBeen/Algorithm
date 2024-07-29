import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] solution(int n) {
        List<int[]> list = hanoi(n, 1, 3, 2);
        return list.toArray(new int[list.size()][]);
    }

    public List<int[]> hanoi(int n, int start, int end, int mid) {
        List<int[]> list = new ArrayList<>();

        if (n == 1) {
            list.add(new int[]{start, end});
        } else {
            // 1번 기둥의 n-1개를 3번을 걸쳐 2번으로 이동시킴
            list.addAll(hanoi(n - 1, start, mid, end));

            // 가장 큰 n을 1에서 3으로 이동시킴
            list.add(new int[]{start, end});

            // 2번의 기둥의 n-1개를 1번을 걸쳐 3번으로 이동시킴
            list.addAll(hanoi(n - 1, mid, end, start));
        }

        return list;
    }
}