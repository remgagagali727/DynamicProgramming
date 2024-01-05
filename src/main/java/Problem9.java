import java.util.*;

public class Problem9 {

    public static int countingChange(int amount, List<Integer> coins) {
        return countingChange(0, amount, coins, new HashMap<>());
    }

    public static int countingChange(int pos, int amount, List<Integer> coins, HashMap<List<Integer>,Integer> memo) {
        if(amount == 0) return 1;
        if(coins.size()==pos) return 0;

        List<Integer> casee = List.of(amount,pos);

        if(memo.containsKey(casee)) return memo.get(casee);

        int coin = coins.get(pos);

        pos++;

        int ans = 0;

        for(int i = 0;i*coin <= amount;i++) {
            ans+=countingChange(pos,amount-i*coin,coins,memo);
        }

        memo.put(casee,ans);

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(countingChange(4, List.of(1, 2, 3)));
    }
}
