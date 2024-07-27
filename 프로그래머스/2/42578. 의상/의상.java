import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        // 옷의 종류별로 갯수를 저장할 Map 선언
        HashMap<String, Integer> map = new HashMap<>();

        // 배열을 순회하면서 옷의 종류별로 갯수를 카운팅한다.
        for (String[] item : clothes) {
            // 옷을 입지 않는 선택지 까지 포함하기 위해 기본값을 1로 준다.
            map.put(item[1], map.getOrDefault(item[1], 1) + 1);
        }

        int answer = 0;

        // 옷을 조합할 수 있는 경우의 수를 계산한다.
        for (int cnt : map.values()) {
            answer = answer == 0 ? cnt : answer * cnt;
        }

        // 위의 연산은 옷을 하나도 입지 않는 케이스가 포함된 연산이므로
        // 옷을 하나도 입지 않은 경우의 수 하나는 제거한다.
        --answer;

        return answer;
    }
}