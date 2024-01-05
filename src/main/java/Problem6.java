
import java.util.*;

public class Problem6 {

    public static void main(String[] args) {

        List<List<Integer>> grid = List.of(
                List.of(1, 1, 3, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1),
                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                List.of(1, 2, 1, 1, 6, 1, 1, 5, 1, 1, 0, 0, 1),
                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                List.of(1, 1, 1, 5, 1, 1, 1, 1, 0, 1, 1, 1, 1),
                List.of(2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                List.of(2, 1, 1, 1, 1, 8, 1, 1, 1, 1, 1, 1, 1),
                List.of(2, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                List.of(1, 1, 1, 1, 1, 1, 1, 9, 1, 1, 1, 1, 1),
                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                List.of(1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 8, 1, 1, 1),
                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                List.of(1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                List.of(1, 42, 1, 1, 1, 1, 1, 1, 1, 8, 1, 1, 1),
                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
        );


        System.out.println(maxPathSum(grid));
    }

    public static int maxPathSum(List<List<Integer>> grid) {
        return maxPathSum(0, 0,grid, new HashMap<>());
    }

    public static int maxPathSum(int x, int y, List<List<Integer>> grid, HashMap<List<Integer>,Integer> memo) {
        if(x==grid.size()-1&&y==grid.get(0).size()-1) return grid.get(x).get(y);
        if(x==grid.size()||y==grid.get(0).size()) return 0;

        List<Integer> pos = List.of(x,y);

        if(memo.containsKey(pos)) return memo.get(pos);

        int ans = grid.get(x).get(y);
        ans+= Math.max(maxPathSum(x+1,y,grid,memo),maxPathSum(x,y+1,grid,memo));

        memo.put(pos,ans);

        return ans;
    }

}
