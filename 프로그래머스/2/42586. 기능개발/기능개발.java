import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 배포 회차별 배포 사이즈를 담을 리스트 선언한다.
        ArrayList<Integer> answerList = new ArrayList<>();

        // 배포가 된 작업은 progresses에서 지워가면서 모두 배포될 때 까지 반복한다.
        while (progresses.length > 0) {
            // 작업 속도에 따른 작업 진행도 갱신
            for (int i = 0; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }

            // 배포 가능한 작업 개수를 카운트할 변수 선언한다.
            int cnt = 0;

            // 배포가능한 작업을 카운트한다.
            for (int progress : progresses) {
                if (progress >= 100) {
                    cnt++;
                } else {
                    break;
                }
            }

            // 배포가능한 작업이 있다면 배포처리를 한다.
            if (cnt > 0) {
                // 배포 후 남은 작업들만 추려서 진행도 리스트와 작업속도 리스트를 갱신한다.
                int[] newProgresses = new int[progresses.length - cnt];
                int[] newSpeeds = new int[speeds.length - cnt];

                for (int i = 0; i < progresses.length - cnt; i++) {
                    newProgresses[i] += progresses[i + cnt];
                    newSpeeds[i] += speeds[i + cnt];
                }

                progresses = newProgresses;
                speeds = newSpeeds;

                // 배포 가능한 작업 개수를 응답 리스트에 입력한다.
                answerList.add(cnt);
            }
        }

        return answerList.stream().mapToInt(integer -> integer).toArray();
    }
}