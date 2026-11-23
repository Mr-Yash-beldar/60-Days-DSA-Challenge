import java.util.*;

public class ActivityDay {
    static class Box {
        int minX, minY, maxX, maxY;
        int area;
        String str;

        Box(int minX, int minY, int maxX, int maxY, String str) {
            this.minX = minX;
            this.minY = minY;
            this.maxX = maxX;
            this.maxY = maxY;
            this.area = (maxX - minX) * (maxY - minY);
            this.str = str;
        }
    }

    static int N, M;
    static boolean[][] rightBlocked, upBlocked;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int L = sc.nextInt();

        rightBlocked = new boolean[N][M];
        upBlocked = new boolean[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < L; i++) {
            int x1 = sc.nextInt(), y1 = sc.nextInt(), x2 = sc.nextInt(), y2 = sc.nextInt();
            if (x1 == x2) {
                int lx = x1;
                int minY = Math.min(y1, y2);
                int maxY = Math.max(y1, y2);
                for (int y = minY; y < maxY; y++) {
                    if (lx > 0 && lx <= N)
                        rightBlocked[lx - 1][y] = true;
                }
            } else {
                int ly = y1;
                int minX = Math.min(x1, x2);
                int maxX = Math.max(x1, x2);
                for (int x = minX; x < maxX; x++) {
                    if (ly > 0 && ly <= M)
                        upBlocked[x][ly - 1] = true;
                }
            }
        }

        int R = sc.nextInt();
        sc.nextLine();
        String[] strings = sc.nextLine().split(" ");

        List<Box> boxes = new ArrayList<>();
        int idx = 0;

        for (int y = 0; y < M; y++) {
            for (int x = 0; x < N; x++) {
                if (!visited[x][y]) {
                    int[] bounds = bfs(x, y);
                    if (idx < strings.length)
                        boxes.add(new Box(bounds[0], bounds[1], bounds[2], bounds[3], strings[idx++]));
                }
            }
        }

        boxes.sort((a, b) -> {
            if (b.area != a.area)
                return b.area - a.area;
            if (a.minX != b.minX)
                return a.minX - b.minX;
            return a.minY - b.minY;
        });

        String target = boxes.get(R - 1).str;
        int sum = 0;
        for (char c : target.toCharArray())
            sum += c;
        System.out.print(sum);
    }

    static int[] bfs(int sx, int sy) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { sx, sy });
        visited[sx][sy] = true;

        int minX = sx, minY = sy, maxX = sx + 1, maxY = sy + 1;

        int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
            maxX = Math.max(maxX, x + 1);
            maxY = Math.max(maxY, y + 1);

            for (int d = 0; d < 4; d++) {
                int nx = x + dirs[d][0], ny = y + dirs[d][1];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                    if (d == 0 && rightBlocked[x][y])
                        continue;
                    if (d == 1 && upBlocked[x][y])
                        continue;
                    if (d == 2 && rightBlocked[nx][ny])
                        continue;
                    if (d == 3 && upBlocked[nx][ny])
                        continue;

                    visited[nx][ny] = true;
                    q.add(new int[] { nx, ny });
                }
            }
        }
        return new int[] { minX, minY, maxX, maxY };
    }
}