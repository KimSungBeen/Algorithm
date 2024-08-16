import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> playerMap = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            playerMap.put(players[i], i);
        }

        for (String calling : callings) {
            int index = playerMap.get(calling);

            String aheadPlayer = players[index - 1];
            players[index - 1] = calling;
            players[index] = aheadPlayer;

            playerMap.put(calling, index -1);
            playerMap.put(aheadPlayer, index);
        }

        return players;
    }
}