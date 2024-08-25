import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][] maps;
    boolean[][] visited;

    int rowSize;
    int columnSize;

    // 상, 하, 좌, 우
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    public int solution(int[][] maps) {
        this.maps = maps;
        this.rowSize = maps.length;
        this.columnSize = maps[0].length;
        this.visited = new boolean[this.rowSize][this.columnSize];

        return bfs(0, 0);
    }

    private int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 1}); // {x, y, 이동한 칸 수}
        this.visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int cnt = current[2];

            // 목표 지점에 도달하면 이동한 칸 수 반환
            if (x == this.rowSize - 1 && y == this.columnSize - 1) {
                return cnt;
            }

            // 현재 위치에서 이동 가능한 방향으로 이동
            for (int i = 0; i < 4; i++) {
                int nextX = x + this.dx[i];
                int nextY = y + this.dy[i];

                if (nextX >= 0 && nextX < this.rowSize &&
                    nextY >= 0 && nextY < this.columnSize &&
                    this.maps[nextX][nextY] == 1 &&
                    !this.visited[nextX][nextY]
                ) {
                    this.visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY, cnt + 1});
                }
            }
        }

        // 목표 지점에 도달할 수 없으면 -1 반환
        return -1;
    }
}