import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Comparator;

public class QueueReconstructionbyHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        List<int[]> res = new LinkedList<>();
        for(int[] p:people){
            res.add(p[1], p);
        }
        return res.toArray(new int[0][0]);
    }
}
