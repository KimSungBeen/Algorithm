import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public boolean solution(String[] phone_book) {
       // 전화번호의 길이는 1~20 이고
        // 배열의 길이는 1 ~ 1,000,000 이므로
        // 효율적인 탐색을 위해 배열을 전화번호 길이의 오름차순으로 정렬
        Arrays.sort(phone_book);

        // 배열의 첫번째 원소부터 순차적으로 다른 원소들의 접두어인 경우가 있는지 탐색 하고
        // 있다면 false 를 리턴
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        // 한 번호가 다른 번호의 접두어인 경우가 없다면 true 리턴
        return true;
    }
}