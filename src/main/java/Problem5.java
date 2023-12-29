import java.util.HashMap;
import java.util.List;

public class Problem5 {

    public static void main(String[] args) {
        List<List<String>> grid = List.of(
                List.of("O", "O", "X", "X", "O", "O", "O", "X", "O", "O", "O", "O", "O", "O", "O"),
                List.of("O", "O", "X", "X", "O", "O", "O", "X", "O", "O", "O", "O", "O", "O", "O"),
                List.of("O", "O", "O", "X", "O", "O", "O", "X", "O", "O", "O", "O", "O", "O", "O"),
                List.of("X", "O", "O", "O", "O", "O", "O", "X", "O", "O", "O", "O", "O", "O", "O"),
                List.of("X", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
                List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "X", "X", "O"),
                List.of("O", "O", "O", "O", "O", "O", "O", "X", "O", "O", "O", "O", "O", "X", "O"),
                List.of("O", "O", "O", "O", "O", "O", "O", "O", "X", "O", "O", "O", "O", "O", "O"),
                List.of("X", "X", "X", "O", "O", "O", "O", "O", "O", "X", "O", "O", "O", "O", "O"),
                List.of("O", "O", "O", "O", "X", "X", "O", "O", "O", "O", "X", "O", "O", "O", "O"),
                List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
                List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
                List.of("O", "O", "O", "O", "X", "X", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
                List.of("O", "O", "O", "O", "O", "O", "O", "O", "X", "O", "O", "O", "O", "O", "O"),
                List.of("O", "O", "O", "O", "O", "O", "O", "O", "X", "O", "O", "O", "O", "O", "O")
        );
        System.out.println(countPaths(grid));
    }

    public static int countPaths(List<List<String>> grid) {
        return countPaths(0, 0, grid, new HashMap<>());
    }

    public static int countPaths(int r, int c, List<List<String>> grid, HashMap<List<Integer>, Integer> memo) {

        if(r == grid.size() || c == grid.get(0).size()) return 0;

        if(grid.get(r).get(c).equals("X")) return 0;

        if(r == grid.size()-1 && c == grid.get(0).size()-1) return 1;

        List<Integer> cord = List.of(r, c);
        if(memo.containsKey(cord)) return memo.get(cord);

        int ans = countPaths(r+1,c,grid,memo)+countPaths(r,c+1,grid,memo);
        memo.put(cord,ans);
        return ans;
    }


}
