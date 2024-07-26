import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings);

        Arrays.sort(strings, new Comparator<>() {
            @Override
            public int compare(String s, String t1) {
                if (s.charAt(n) > t1.charAt(n)) {
                    return 1;
                } else if (s.charAt(n) == t1.charAt(n)) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        return strings;
    }
}