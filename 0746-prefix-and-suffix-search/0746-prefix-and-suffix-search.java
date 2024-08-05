import java.util.HashMap;
import java.util.Map;

class WordFilter {
    Map<String, Integer> map = new HashMap<>();

    public WordFilter(String[] words) {
        for (int i = 0; i < words.length; i++) {
            for (int j = 1; j <= words[i].length(); j++) {
                String pref = words[i].substring(0, j);

                for (int k = words[i].length() - 1; k >= 0; k--) {
                    String suff = words[i].substring(k);

                    map.put(pref + "&" + suff, i);
                }
            }
        }
    }

    public int f(String pref, String suff) {
        return map.getOrDefault(pref + "&" + suff, -1);
    }
}