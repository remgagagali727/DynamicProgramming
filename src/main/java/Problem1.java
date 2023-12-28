
//Fibonacci Problem
//Recursive Programming
//Memorization

import java.util.HashMap;
import java.util.Scanner;

public class Problem1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Give me a number:");
        int n = in.nextInt();
        System.out.println("The fib output of "+n+ " is "+fib(n));

    }

    private static int fib(int n){
        return fibhelper(n, new HashMap<Integer, Integer>());
    }

    public static int fibhelper(int n, HashMap<Integer, Integer> memo){
        //Base cases of fibonacci
        if(n==0 || n==1) return n;

        //Checks if we have the fibonacci value saved and returns it
        if(memo.containsKey(n)) return memo.get(n);

        //Gets and saves the fibonacci value of n
        int fibr = fibhelper(n-1, memo) + fibhelper(n-2, memo);
        memo.put(n,fibr);

        return fibr;
    }
}
