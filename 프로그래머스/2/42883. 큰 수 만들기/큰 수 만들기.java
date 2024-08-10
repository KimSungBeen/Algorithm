class Solution {
    public String solution(String number, int k) {
        StringBuilder sb_number = new StringBuilder(number);
        
        int i = 0;

        // number에서 숫자가 k개 만큼 제거될 때 까지 반복
        while (k > 0) {
            if (i >= sb_number.length() - 1) { // numbers의 마지막 인덱스까지 지울 숫자가 없으면 마지막 인덱스 숫자를 제거
                sb_number.deleteCharAt(sb_number.length() - 1);
                k--;
            } else if (sb_number.charAt(i) < sb_number.charAt(i + 1)) { // i+1 번째 숫자가 i번째 숫자 보다 크면 i번째 숫자 제거
                sb_number.deleteCharAt(i);
                k--;

                // 숫자를 제거한 후 탐색 시작 위치를 이미 검증된 숫자들 이후부터 하도록 i 값 초기화
                i = i > 0 ? i - 1 : 0;
            } else {
                i++;
            }
        }

        return sb_number.toString();
    }
}