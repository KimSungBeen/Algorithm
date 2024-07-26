class Solution {
    public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];

        int index = 0;
        for (long i = left; i < right + 1; i++) {
            int row = (int) (i / n);
            int column = (int) (i % n);

            answer[index++] = Math.max(row, column) + 1;
        }

        return answer;
    }
}