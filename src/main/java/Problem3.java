
//Given an array of n numbers and a t target number return false or true if we can sum any of the numbers in the
//array, so we can get t

import java.util.*;

public class Problem3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Give me a target");
        int t = in.nextInt();
        List<Integer> a = new ArrayList<>();
        int add;
        while(true){
            System.out.println("Give me the next number in the array (negative to break)");
            add = in.nextInt();
            if (add < 0) break;
            a.add(add);
        }


        System.out.println("The problem "+(sumPossible(t,a)?"can":"can't")+" be solved.");
    }

    public static boolean sumPossible(int t, List<Integer> a) {

        return sumPossible(t,a, new HashMap<>());
    }

    private static boolean sumPossible(int t, List<Integer> a, HashMap<Integer, Boolean> dic) {
        //Base test cases if t equals 0 then true, if t is negative then false
        if(t==0) return true;
        if(t<0) return false;

        //Checks the memory
        if(dic.containsKey(t)) return dic.get(t);

        boolean ans = false;
        for(int sa : a)
            ans|=sumPossible(t-sa,a,dic);
        dic.put(t,ans);
        return ans;
    }


}
