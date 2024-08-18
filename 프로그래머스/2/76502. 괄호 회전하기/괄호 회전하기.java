import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;

        if(s.length() == 1) return answer;

        // 문자열의 맨 앞 문자를 뽑아서 뒤로 붙이는 방식으로 문자열을 회전시키기 위해 Queue 사용
        Queue<String> sQueue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            sQueue.offer(String.valueOf(s.charAt(i)));
        }

        // s의 길이만큼 s를 회전 시키는 반복문 선언
        for (int i = 0; i < s.length(); i++) {
            // sQueue를 복제
            Queue<String> tempQueue = new LinkedList<>(sQueue);

            Stack<String> tempStack = new Stack<>();

            for (int j = 0; j < s.length(); j++) {
                tempStack.push(tempQueue.poll());

                if (tempStack.peek().equals(")") || tempStack.peek().equals("}") || tempStack.peek().equals("]")) {
                    if (tempStack.size() < 2) {
                        break;
                    }

                    String u = tempStack.pop() + tempStack.pop();

                    if (!(u.equals(")(") || u.equals("}{") || u.equals("]["))) {
                        break;
                    }
                }

                // 정상적으로 반복문을 모두 마친 경우 +1
                if (j == s.length() - 1 && tempStack.size() == 0) {
                    answer++;
                }
            }

            // 문자열을 왼쪽으로 한칸 회전
            sQueue.offer(sQueue.poll());
        }

        return answer;
    }
}