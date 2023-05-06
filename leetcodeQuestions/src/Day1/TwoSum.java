package Day1;
import java.util.*;
public class TwoSum {

    // T.C -> O(N^2) brute force
    /*public int[] twoSum(int[] nums, int target) {

        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }*/

    // efficient T.C -> O(N)
    public int[] twoSum(int[] arr, int target) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            int sno = target - arr[i];
            if(map.containsKey(sno)){
                return new int[]{map.get(sno),i};
            }
            map.put(arr[i],i);
        }
        return new int[]{-1,-1};
    }
}
