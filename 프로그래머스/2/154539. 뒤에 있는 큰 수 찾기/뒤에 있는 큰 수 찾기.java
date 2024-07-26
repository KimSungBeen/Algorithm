import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Stack<Integer> st = new Stack<>();

        for (int i = numbers.length - 1; i >= 0; i--) {
            answer[i] = -1; // 초기화

            while (!st.isEmpty()) {
                if (numbers[i] < st.peek()) {
                    answer[i] = st.peek();
                    break;
                } else {
                    st.pop();
                }
            }

            st.push(numbers[i]);
        }

        return answer;
    }
}
