package Day2;

import java.util.Scanner;

public class Majority_Element {
    public static void main(String[] args) {

        int[] arr = {2,5,2,2,7,4,2,2,1};
        System.out.println(majorityElement(arr));
    }

    //Using HashMaps Approach
    //T.C -> O(n) , S.C -> O(n)
    /*public static int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        //edge cases
        if(nums.length<=2){
            return nums[0];
        }

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if(map.get(nums[i])>=nums.length/2){
                    return nums[i];
                }
            }
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        return -1;
    }*/

    //Moore’s Voting Algorithm
    // T.C -> O(n) S.C -> O(1)
    public static int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        for(int i=1;i<nums.length;i++){
            if(candidate==nums[i]){
                count++;
            }
            else{
                count--;
            }
            if(count==0){
                candidate = nums[i];
                count = 1;
            }
        }

        int cnt = 0;
        //now verify if given cadidate is answer or not
        for(int i=0;i<nums.length;i++){
            if(candidate==nums[i]){
                cnt++;
            }
        }
        if(cnt>=nums.length/2){
            return candidate;
        }else{
            return -1;
        }
    }
}
