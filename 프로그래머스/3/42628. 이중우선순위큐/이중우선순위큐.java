import java.util.PriorityQueue;

class Solution {
    public static int[] solution(String[] operations) {
        // 힙 선언
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (String o : operations) {
            // 큐에서 최대값을 삭제한다.
            if (!pq.isEmpty() && o.equals("D 1")) {
                PriorityQueue<Integer> newPq = new PriorityQueue<>();

                int size = pq.size();
                for (int i = 0; i < size - 1; i++) {
                    newPq.offer(pq.poll());
                }

                pq = newPq;
            }
            // 큐에서 최소값을 삭제한다.
            else if (!pq.isEmpty() && o.equals("D -1")) {
                pq.poll();
            }
            // 큐에 숫자를 삽입힌다.
            else if (o.startsWith("I")) {
                int i = Integer.parseInt(o.substring(2));
                pq.offer(i);
            }
        }

        int size = pq.size();
        int[] answer = new int[]{0, 0};
        
        for (int i = 0; i < size; i++) {
            int value = pq.poll();
            
            if (i == 0) {
                answer[1] = value;

                // 큐의 사이즈가 1일 수도 있으므로 최댓값도 갱신해준다.
                answer[0] = value;
            } else if (i == size - 1) {
                answer[0] = value;
            }
        }

        return answer;
    }
}