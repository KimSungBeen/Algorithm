import java.util.*;

public class Main {
    static ArrayList<String> results = new ArrayList<>();
    static char[] signs;
    static boolean[] used = new boolean[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        signs = new char[k];

        for (int i = 0; i < k; i++) {
            signs[i] = sc.next().charAt(0);
        }

        dfs("", 0, k);

        Collections.sort(results);

        System.out.println(results.get(results.size() - 1)); // 최대값 출력
        System.out.println(results.get(0)); // 최소값 출력
    }

    // DFS를 이용하여 모든 가능한 숫자 조합을 확인
    static void dfs(String num, int depth, int k) {
        if (depth == k + 1) {
            results.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (!used[i]) {
                if (depth == 0 || check(num.charAt(depth - 1) - '0', i, signs[depth - 1])) {
                    used[i] = true;
                    dfs(num + i, depth + 1, k);
                    used[i] = false;
                }
            }
        }
    }

    // 부등호를 체크하여 숫자가 조건을 만족하는지 확인
    static boolean check(int a, int b, char sign) {
        if (sign == '<') return a < b;
        else return a > b;
    }
}