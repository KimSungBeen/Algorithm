import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int centerIndex = citations.length / 2;
        while (0 <= centerIndex && centerIndex < citations.length) {
            int center = citations[centerIndex];
            int afterCnt = citations.length - (centerIndex + 1);
            int beforeCnt = centerIndex;

            if (center <= afterCnt) {
                if (center >= beforeCnt) {
                    return center;
                } else {
                    centerIndex++;
                }
            } else {
                centerIndex--;
            }
        }

        return 0;
    }
}