import java.util.HashMap;

public class Problem8 {

    public static int summingSquares(int n) {
        return summingSquares(n,new HashMap<>());
    }

    public static int summingSquares(int n, HashMap<Integer, Integer> memo) {
        int ans = Integer.MAX_VALUE;
        if(n==0) return 0;
        if(n<0) return ans;

        if(memo.containsKey(n)) return memo.get(n);

        for(int i = 1;i*i<=n;i++){
            int temp = summingSquares(n-i*i,memo);
            if(ans > temp) ans = temp;
        }
        ans++;

        memo.put(n,ans);

        return ans;

    }


    public static void main(String[] args) {
        System.out.println(summingSquares(113));
    }
}
