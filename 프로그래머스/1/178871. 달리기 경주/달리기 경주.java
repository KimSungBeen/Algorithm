import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        // callings를 순회할 때 플레이어의 등수를 빠르게 얻기 위한 Map 선언
        HashMap<String, Integer> playerMap = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            playerMap.put(players[i], i);
        }

        // callings를 순회
        for (String calling : callings) {
            // 불려진 이름의 등수(index)를 가져온다.
            int index = playerMap.get(calling);

            // 이름이 불려진 플레이어와 앞 순위 플레이어의 순위를 변경한다.
            String aheadPlayer = players[index - 1];
            players[index - 1] = calling;
            players[index] = aheadPlayer;

            // Map의 value로 가지고 있던 등수 또한 갱신해준다.
            playerMap.put(calling, index - 1);
            playerMap.put(aheadPlayer, index);
        }

        return players;
    }
}