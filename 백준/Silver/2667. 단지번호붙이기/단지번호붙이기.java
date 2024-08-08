import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix;

        int N = Integer.parseInt(sc.nextLine()); // 지도의 크기 N x N
        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] row = sc.nextLine().split("");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }

        Graph graph = new Graph(N, matrix);

        List<Integer> houseGroupList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!graph.map[i][j].visited && graph.map[i][j].data == 1) {
                    int cnt = graph.dfs(i, j);
                    houseGroupList.add(cnt);
                }
            }
        }

        Collections.sort(houseGroupList);

        System.out.println(houseGroupList.size());
        for (int i : houseGroupList) {
            System.out.println(i);
        }
    }
}

class Graph {
    Node[][] map;
    int size;

    // 위, 왼쪽, 아래, 오른쪽
    int[] dx = {0, -1, 0, 1};
    int[] dy = {-1, 0, 1, 0};

    Graph(int size, int[][] map) {
        this.size = size;
        this.map = new Node[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.map[i][j] = new Node(i, j, map[i][j]);
            }
        }
    }

    public int dfs(int x, int y) {
        // 대기열
        Stack<Node> s = new Stack();

        // 인접한 집의 갯수
        int count = 0;

        s.push(this.map[x][y]);
        this.map[x][y].visited = true;

        while (!s.isEmpty()) {
            Node n = s.pop();

            count++;

            for (int i = 0; i < 4; i++) {
                int newX = n.x + dx[i];
                int newY = n.y + dy[i];

                if (newX < 0 || newX >= this.size || newY < 0 || newY >= this.size) continue;

                Node visitNode = map[newX][newY];

                if (!visitNode.visited && visitNode.data == 1) {
                    s.push(visitNode);
                    visitNode.visited = true;
                }
            }
        }
        return count;
    }

    static class Node {
        int data;
        int x;
        int y;
        boolean visited;

        Node(int x, int y, int data) {
            this.data = data;
            this.x = x;
            this.y = y;
            this.visited = false;
        }
    }
}