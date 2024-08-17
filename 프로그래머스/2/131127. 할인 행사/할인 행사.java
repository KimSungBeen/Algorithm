import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        // 원하는 제품과 수량을 Map으로 선언
        HashMap<String, Integer> wantMap = new HashMap<>();

        for (int i = 0; i < number.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        // 10일간 할인 상품과 개수를 저장할 Map 선언
        HashMap<String, Integer> discountMap = new HashMap<>();

        // 10일씩 하루 간격으로 자르는 것을 반복
        for (int discountMapLastIndex = 10; discountMapLastIndex <= discount.length; discountMapLastIndex++) {
            discountMap.clear();

            // 할인 강품과 개수를 Map에 저장
            for (int i = discountMapLastIndex - 10; i < discountMapLastIndex; i++) {
                discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);
            }

            // 회원등록 가능한 날짜를 미리 더해 놓는다.
            answer++;

            for (String s : want) {
                if (!wantMap.get(s).equals(discountMap.getOrDefault(s, 0))) {
                    // 위에서 자른 10일 중에 원하는 항목이 없거나 부족할 경우
                    // 위에서 미리 더한 회원등록 가능한 날짜를 다시 내린다.
                    answer--;
                    break;
                }
            }
        }

        return answer;
    }
}