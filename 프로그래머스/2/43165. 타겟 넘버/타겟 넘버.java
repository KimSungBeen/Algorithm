class Solution {
    int[] numbers;
    int target;

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;

        return dfs(0, 0, 0);
    }

    private int dfs(int index, int value, int cnt) {
        // index가 끝까지 도달했는지 먼저 체크하기 때문에 
        // 배열의 원소를 모두 연산하기 위해 index가 lastIndex + 1 (= length) 일때 값이 target과 값이 같은지 체크  
        if (index == this.numbers.length) {
            if (value == this.target) {
                cnt++;
            }
        } else {
            // 더하기
            cnt = dfs(index + 1, value + this.numbers[index], cnt);

            // 빼기
            cnt = dfs(index + 1, value - this.numbers[index], cnt);
        }

        return cnt;
    }
}