import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        List<Integer> scovilleList = new ArrayList<>();

        for (int s : scoville) {
            scovilleList.add(s);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(scovilleList);

        if (pq.peek() > K) {
            return 0;
        }

        int answer = 0;

        while (pq.size() >= 2 && pq.peek() < K) {
            int mixedScoville = pq.poll() + pq.poll() * 2;

            pq.offer(mixedScoville);

            answer++;
        }

        if(pq.peek() < K) {
            answer = -1;
        }

        return answer;
    }
}