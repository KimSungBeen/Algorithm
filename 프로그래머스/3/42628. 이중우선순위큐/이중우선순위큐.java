import java.util.Collections;
import java.util.PriorityQueue;
import java.util.*;

class Solution {
    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            String[] temp = operation.split(" ");

            if (temp[0].equals("I")) {
                minHeap.add(Integer.parseInt(temp[1]));
                maxHeap.add(Integer.parseInt(temp[1]));
            } else if(!maxHeap.isEmpty() && temp[0].equals("D") && temp[1].equals("1")) {
                Integer max = maxHeap.poll();
                minHeap.remove(max);
            } else if(!minHeap.isEmpty() && temp[0].equals("D") && temp[1].equals("-1")) {
                Integer min = minHeap.poll();
                maxHeap.remove(min);
            }
        }

        int[] answer = new int[2];

        if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = maxHeap.poll();
            answer[1] = minHeap.poll();
        }

        return answer;
    }
}