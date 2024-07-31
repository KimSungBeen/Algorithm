import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        List<Integer> scovilleList = new ArrayList<>();

        for (int s : scoville) {
            scovilleList.add(s);
        }

        // 가장 맵지 않은 순서대로 정렬된 최소 힙을 만들기위해 위해 우선순위 큐 사용
        PriorityQueue<Integer> pq = new PriorityQueue<>(scovilleList);

        // 만약 가장 맵지 않은 음식이 K 보다 크다면 0을 리턴
        if (pq.peek() > K) {
            return 0;
        }

        int answer = 0;

        while (pq.size() >= 2 && pq.peek() < K) {
            int mixedScoville = pq.poll() + pq.poll() * 2;

            pq.offer(mixedScoville);

            answer++;
        }

        // 만약 K보다 매운 음식을 만들 수 없다면 -1 리턴
        if (pq.peek() < K) {
            return -1;
        }

        return answer;
    }
}
