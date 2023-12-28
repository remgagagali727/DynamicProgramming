
//Tribonacci Problem

import java.util.HashMap;
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Give me a number:");
        int n = in.nextInt();
        System.out.println("The tib output of "+n+ " is "+tib(n));
    }

    public static int tib(int n) {
        return tibh(n,new HashMap<>());
    }

    //Tribonacci Helper Class
    private static int tibh(int n, HashMap<Integer, Integer> dic) {
        //Base cases
        if(n==0||n==1) return 0;
        if(n==2) return 1;

        //Returns the tribonacci value of n if its memorized
        if(dic.containsKey(n)) return dic.get(n);

        return tibh(n-1,dic)+tibh(n-2,dic)+tibh(n-3,dic);

    }

}
