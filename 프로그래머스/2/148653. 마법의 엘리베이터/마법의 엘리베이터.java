class Solution {
    public int solution(int storey) {
        int answer = 0;

        String[] splitedStorey = String.valueOf(storey).split("");

        for (int i = 0; i < splitedStorey.length; i++) {
            int int_unit = Integer.parseInt(splitedStorey[i]);

            if (int_unit == 10) {
                answer++;
            } else if (int_unit >= 5) {
                answer += (10 - int_unit);
                int nextValue = Integer.parseInt(splitedStorey[i + 1]) + 1;
                splitedStorey[i + 1] = String.valueOf(nextValue);
            } else {
                answer += int_unit;
            }
        }

        return answer;
    }
}