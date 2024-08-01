import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> cardQueue1 = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> cardQueue2 = new LinkedList<>(Arrays.asList(cards2));
        Queue<String> goalQueue = new LinkedList<>(Arrays.asList(goal));

        while (!goalQueue.isEmpty()) {
            if (goalQueue.peek().equals(cardQueue1.peek())) {
                goalQueue.poll();
                cardQueue1.poll();
            } else if (goalQueue.peek().equals(cardQueue2.peek())) {
                goalQueue.poll();
                cardQueue2.poll();
            } else {
                return "No";
            }
        }

        return "Yes";
    }
}