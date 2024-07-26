import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public boolean solution(String[] phone_book) {
        // 효율적인 탐색을 위해 배열을 정렬
        Arrays.sort(phone_book);

        // 위에서 정렬을 했으므로 붙어있는 원소끼리만 비교하면 
        // 한 번호가 다른 번호의 접두어인 경우가 있는지 여부를 알 수 있음 
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        // 한 번호가 다른 번호의 접두어인 경우가 없다면 true 리턴
        return true;
    }
}