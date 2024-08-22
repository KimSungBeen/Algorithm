import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public int[] solution(String[] maps) {
        Graph graph = new Graph(maps);

        List<Integer> answer = new ArrayList<>();

        // 행렬의 각 원소들을 순회
        for (int i = 0; i < graph.rowSize; i++) {
            for (int j = 0; j < graph.columnSize; j++) {
                // 만약 원소의 값이 0이거나 이미 확인한 곳이라면 넘어간다.
                if (graph.map[i][j].data == 0 || graph.map[i][j].marked) continue;

                // 인접한 원소들을 탐색하기 위한 Stack 선언
                Stack<Graph.Node> s = new Stack<>();
                s.push(graph.map[i][j]);
                graph.map[i][j].marked = true;

                // 인접한 원소들의 합산 값이 저장될 변수
                int amount = 0;

                // 인접한 원소들 탐색
                while (!s.isEmpty()) {
                    Graph.Node node = s.pop();
                    amount += node.data;

                    for (int k = 0; k < 4; k++) {
                        int newX = node.x + graph.dx[k];
                        int newY = node.y + graph.dy[k];

                        // 이어져 있지 않은 곳이거나 이미 확인한 곳이라면 넘어간다.
                        if (newX < 0 ||
                                newX > graph.rowSize - 1 ||
                                newY < 0 ||
                                newY > graph.columnSize - 1 ||
                                graph.map[newX][newY].data == 0 ||
                                graph.map[newX][newY].marked
                        ) continue;

                        s.push(graph.map[newX][newY]);
                        graph.map[newX][newY].marked = true;
                    }
                }

                // 원소의 값을 합산한다.
                if (amount > 0) {
                    answer.add(amount);
                }
            }
        }

        if (answer.isEmpty()) {
            return new int[]{-1};
        } else {
            return answer.stream().sorted().mapToInt(Integer::intValue).toArray();
        }
    }
}

class Graph {
    Node[][] map;
    int columnSize;
    int rowSize;

    // 상, 하, 좌, 우
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    public Graph(String[] maps) {
        this.rowSize = maps.length;
        this.columnSize = maps[0].length();
        this.map = new Node[this.rowSize][this.columnSize];

        // 인자로 받은 maps를 행렬로 변환한다.
        for (int i = 0; i < this.rowSize; i++) {
            for (int j = 0; j < this.columnSize; j++) {
                String[] row = maps[i].split("");

                Node node;

                // 인접한 원소들의 합을 구할때 용이하게 하기위해 X라면 정수 0으로 치환한다.
                if (row[j].equals("X")) {
                    node = new Node(i, j, 0);
                } else {
                    node = new Node(i, j, Integer.parseInt(row[j]));
                }

                this.map[i][j] = node;
            }
        }
    }

    static class Node {
        int x;
        int y;
        int data;
        boolean marked;

        public Node(int x, int y, int data) {
            this.x = x;
            this.y = y;
            this.data = data;
            this.marked = false;
        }
    }
}
