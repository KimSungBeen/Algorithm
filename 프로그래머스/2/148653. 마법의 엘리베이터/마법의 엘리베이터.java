class Solution {
    public int solution(int storey) {
        // storey를 자리수 하나하나씩 분해하기 위해 String 으로 형변환
        String string_storey = String.valueOf(storey);

        // (+) 연산후 0번 인덱스의 값이 10이 된다면,
        // 값을 올려주기 위해 배열 사이즈를 1만큼 더 크게 선언 후 "0"으로 초기화
        String[] arr_storey = new String[string_storey.length() + 1];
        arr_storey[0] = "0";

        // 배열의 1번 인덱스부터 storey의 자리수를 하나하나씩 삽입
        for (int i = 0; i < string_storey.length(); i++) {
            arr_storey[i + 1] = String.valueOf(string_storey.charAt(i));
        }

        int answer = 0;

        // 앞쪽 값이 뒷쪽 값의 (+) 연산에 의해 달라질 수 있으므로 배열의 뒤부터 순회
        for (int i = arr_storey.length - 1; i >= 0; i--) {
            // 현재 위치 값을 int로 형변환
            int value = Integer.parseInt(arr_storey[i]);

            // 조건 분기에 사용될 다음 위치 값
            int next_value = 0;
            if (i > 0) {
                next_value = Integer.parseInt(arr_storey[i - 1]);
            }

            // 다음 위치값이 5이상이고 현재 위치 값이 5일때 혹은, 현재 위치 값이 5 이상일떄
            if ((next_value >= 5 && value == 5) || value > 5) {
                // (+) 연산 처리
                answer += (10 - value);
                int nextValue = next_value + 1;
                arr_storey[i - 1] = String.valueOf(nextValue);
            } else if (value > 0) {
                // (-) 연산 처리
                answer += value;
            }
        }

        return answer;
    }
}