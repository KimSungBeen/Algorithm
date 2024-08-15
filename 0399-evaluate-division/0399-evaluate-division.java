import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class Solution {
    static class Edge {
        String target; // 연결 대상 노드
        double weight; // 가중치 (변수 간 비율)

        Edge(String target, double weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 그래프를 생성하여 변수 간의 비율 관계를 나타냄
        Map<String, List<Edge>> graph = buildGraph(equations, values);

        // 쿼리 결과를 저장할 배열 초기화
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            var src = queries.get(i).get(0);
            var dst = queries.get(i).get(1);
            Set<String> visited = new HashSet<>(); // 방문한 노드 추적
            results[i] = dfs(src, dst, visited, graph); // DFS를 사용하여 경로 계산
        }

        return results;
    }

    private Map<String, List<Edge>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, List<Edge>> graph = new HashMap<>();
        // 방정식으로부터 그래프 생성
        for (int i = 0; i < equations.size(); i++) {
            String src = equations.get(i).get(0);
            String dest = equations.get(i).get(1);
            double value = values[i];

            // 양방향 관계를 그래프에 추가
            graph.computeIfAbsent(src, k -> new ArrayList<>()).add(new Edge(dest, value));
            graph.computeIfAbsent(dest, k -> new ArrayList<>()).add(new Edge(src, 1 / value));
        }
        return graph;
    }

    private double dfs(String src, String dest, Set<String> visited, Map<String, List<Edge>> graph) {
        if (!graph.containsKey(src)) // 출발 노드가 그래프에 없으면 -1.0 반환
            return -1.0;
        if (src.equals(dest)) // 출발 노드와 도착 노드가 같으면 1.0 반환
            return 1.0;
        visited.add(src); // 현재 노드 방문 처리

        // 현재 노드에서 연결된 모든
        for (Edge edge : graph.get(src)) {
            if (visited.contains(edge.target)) {
                continue; // 이미 방문한 노드는 건너뜀
            }
            double pathValue = dfs(edge.target, dest, visited, graph); // 재귀적으로 DFS 수행
            if (pathValue != -1.0) { // 유효한 경로 발견 시
                return pathValue * edge.weight; // 현재 간선 가중치를 곱하여 결과 반환
            }
        }

        return -1.0; // 경로를 찾을 수 없는 경우 -1.0 반환
    }
}
