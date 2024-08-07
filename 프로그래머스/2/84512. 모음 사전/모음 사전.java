import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String word) {
        String[] d = new String[]{"A", "E", "I", "O", "U"};

        Map<String, Integer> map = new HashMap<>();

        int order = 1;

        for (int i = 0; i < d.length; i++) {
            map.put(d[i], order++);
            for (int j = 0; j < d.length; j++) {
                map.put(d[i] + d[j], order++);
                for (int k = 0; k < d.length; k++) {
                    map.put(d[i] + d[j] + d[k], order++);
                    for (int l = 0; l < d.length; l++) {
                        map.put(d[i] + d[j] + d[k] + d[l], order++);
                        for (int m = 0; m < d.length; m++) {
                            map.put(d[i] + d[j] + d[k] + d[l] + d[m], order++);
                        }
                    }
                }
            }
        }

        return map.get(word);
    }
}
