import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TrappingRainWaterII {

//    public int trapRainWater(int[][] heightMap) {
//        int m=heightMap.length, n=heightMap[0].length;
//        int[][] map=new int[m][n];
//    }
//    public int bfs(int[] p, int[][] heightMap, int[][] map) {
//        if(map[p[0]][p[1]]==1){
//            return 0;
//        }
//        Deque<int[]> queue = new ArrayDeque<>();
//        queue.offer(p);
//        map[p[0]][p[1]]=1;
//        int min = Integer.MAX_VALUE;
//        while (!queue.isEmpty()) {
//            int[] curr = queue.poll();
//            int m = curr[0];
//            int n = curr[1];
//            if(m==0||n==0||m==heightMap.length-1||n==heightMap[0].length-1) {
//                return 0;
//            }
//            int h = heightMap[m][n];
//            int h0 = heightMap[m-1][n];// up
//            int h1 = heightMap[m][n+1];// right
//            int h2 = heightMap[m+1][n];// down
//            int h3 = heightMap[m][n-1];// left
//            if(h < h0 && map[m-1][n]==0) {
//                min = Math.min(min, h0);
//                queue.offer(new int[]{m-1, n});
//                map[m-1][n]=1;
//            }
//            if(h < h1 && map[m][n+1]==0) {
//                min = Math.min(min, h1);
//                queue.offer(new int[]{m, n+1});
//                map[m][n+1]=1;
//            }
//            if(h < h2 && map[m+1][n]==0) {
//                min = Math.min(min, h2);
//                queue.offer(new int[]{m+1, n});
//                map[m+1][n]=1;
//            }
//            if(h < h3 && map[m][n-1]==0) {
//                min = Math.min(min, h3);
//                queue.offer(new int[]{m, n-1});
//                map[m][n-1]=1;
//            }
//            List<Integer> list = new ArrayList<>();
//            list.add();
//        }
//
//    }
}
