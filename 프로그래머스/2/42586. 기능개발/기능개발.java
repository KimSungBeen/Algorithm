import java.util.ArrayList;

class Solution {
    ArrayList<Integer> answer = new ArrayList<>();

    public int[] solution(int[] progresses, int[] speeds) {
        while (progresses.length > 0) {
            for (int i = 0; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }

            int cnt = 0;
            for (int progress : progresses) {
                if (progress >= 100) {
                    cnt++;
                } else {
                    break;
                }
            }

            if (cnt > 0) {
                int[] newProgresses = new int[progresses.length - cnt];
                int[] newSpeeds = new int[speeds.length - cnt];
                for (int i = 0; i < progresses.length - cnt; i++) {
                    newProgresses[i] += progresses[i + cnt];
                    newSpeeds[i] += speeds[i + cnt];
                }

                progresses = newProgresses;
                speeds = newSpeeds;

                answer.add(cnt);
            }
        }

        return answer.stream().mapToInt(integer -> integer).toArray();
    }
}