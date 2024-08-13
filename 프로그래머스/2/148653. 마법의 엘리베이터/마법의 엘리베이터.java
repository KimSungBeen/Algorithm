class Solution {
    public int solution(int storey) {
        String string_storey = String.valueOf(storey);
        String[] arr_storey = new String[string_storey.length() + 1];
        arr_storey[0] = "0";

        for (int i = 0; i < string_storey.length(); i++) {
            arr_storey[i + 1] = String.valueOf(string_storey.charAt(i));
        }

        int answer = 0;

        for (int i = arr_storey.length - 1; i >= 0; i--) {
            int int_unit = Integer.parseInt(arr_storey[i]);
            int next_int_value = 0;

            if (i > 0) {
                next_int_value = Integer.parseInt(arr_storey[i - 1]);
            }

            if ((next_int_value >= 5 && int_unit == 5) || int_unit > 5) {
                answer += (10 - int_unit);
                int nextValue = next_int_value + 1;
                arr_storey[i - 1] = String.valueOf(nextValue);
            } else if (int_unit > 0) {
                answer += int_unit;
            }
        }

        return answer;
    }
}