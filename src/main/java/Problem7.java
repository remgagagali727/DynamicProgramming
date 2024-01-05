import java.util.*;
public class Problem7 {


    public static int nonAdjacentSum(List<Integer> nums) {
        return nonAdjacentSum(nums,new HashMap<>());
    }

    private static int nonAdjacentSum(List<Integer> nums, HashMap<List<Integer>,Integer> memo) {
        if(nums.size()==0) return 0;
        if(nums.size()==1) return nums.get(0);
        if(nums.size()==2){
            if(nums.get(0)>nums.get(1)) return nums.get(0);
            return nums.get(1);
        }
        if(memo.containsKey(nums)) return memo.get(nums);

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        a.add(nums.get(1));
        for(int i = 2;i < nums.size();i++){
            int t = nums.get(i);
            a.add(t);
            b.add(t);
        }

        int ans;

        ans = Math.max(nums.get(0)+nonAdjacentSum(b,memo),nonAdjacentSum(a,memo));

        memo.put(nums,ans);

        return ans;

    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(
                72, 62, 10,  6, 20, 19, 42, 46, 24, 78,
                30, 41, 75, 38, 23, 28, 66, 55, 12, 17,
                83, 80, 56, 68,  6, 22, 56, 96, 77, 98,
                61, 20,  0, 76, 53, 74,  8, 22, 92, 37,
                30, 41, 75, 38, 23, 28, 66, 55, 12, 17,
                72, 62, 10,  6, 20, 19, 42, 46, 24, 78,
                42
        );

        System.out.println(nonAdjacentSum(nums));
    }


}
