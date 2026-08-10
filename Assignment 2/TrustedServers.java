import java.util.*;

public class TrustedServers {

    static ArrayList<Integer>[] tree;
    static int[] key;
    static boolean[] visited;
    static int K;
    static int trustedServers = 0;

    static void dfs(int node, int currentXor) {
        visited[node] = true;

        currentXor ^= key[node];

        if (currentXor >= K) {
            trustedServers++;
        }

       
        for (int child : tree[node]) {
            if (!visited[child]) {
                dfs(child, currentXor);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        K = sc.nextInt();

        tree = new ArrayList[N + 1];
        key = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            key[i] = sc.nextInt();
        }

      
        for (int i = 0; i < N - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            tree[u].add(v);
            tree[v].add(u);
        }

        dfs(1, 0);

        System.out.println(trustedServers);

        sc.close();
    }
}