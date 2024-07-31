import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public static int[] solution(String[] operations) {
        // 힙 선언
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (String o : operations) {
            switch (o) {
                case "D 1": {
                    if (!pq.isEmpty()) {
                        PriorityQueue<Integer> newPq = new PriorityQueue<>();

                        for (int i = 0; i < pq.size() - 1; i++) {
                            newPq.offer(pq.poll());
                        }

                        pq = newPq;
                    }
                    break;
                }
                case "D -1": {
                    if (!pq.isEmpty()) {
                        pq.poll();
                    }
                    break;
                }
                default: {
                    int i = Integer.parseInt(o.substring(2));
                    pq.offer(i);
                }
            }
        }

        int n = pq.size();
        int[] answer = new int[2];
        for (int i = n; i >= 1; i--) {
            int value = pq.poll();

            if (i == 1) {
                answer[0] = value;
            } else if (i == n) {
                answer[1] = value;
            }
        }

        return answer;
    }
}