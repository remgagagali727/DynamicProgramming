
//Problem 4: min change

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Problem4 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Give me an amount");
        int t = in.nextInt();
        List<Integer> a = new ArrayList<>();
        int add;
        while(true){
            System.out.println("Give me the next coin value in the array (negative to break)");
            add = in.nextInt();
            if (add < 0) break;
            a.add(add);
        }

        System.out.println("You need at least "+minChange(t,a)+" coins to get the amount.");

    }

    public static int minChange(int t, List<Integer> a) {
        return minChange(t,a,new HashMap<>());
    }

    private static int minChange(int t, List<Integer> a, HashMap<Integer, Integer> memo) {
        if(t==0) return 0;
        if(t<0) return -1;
        if(memo.containsKey(t)) return memo.get(t);

        int ans = -1;
        for(int num : a){
            int subCoins = minChange(t-num, a,memo)+1;
            if(subCoins!=0)
                if(ans == -1 || ans > subCoins)
                    ans = subCoins;
        }
        memo.put(t,ans);
        return ans;
    }

}
