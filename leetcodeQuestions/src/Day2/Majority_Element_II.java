package Day2;
import java.util.*;
public class Majority_Element_II {
    public static void main(String[] args) {

        int[] arr = {2,3};
        ArrayList<Integer> ans = majorityElement(arr);
        for(int val : ans){
            System.out.print(val+" ");
        }

    }

    public static ArrayList<Integer> majorityElement(int[] nums) {

        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])>nums.length/3){
                set.add(nums[i]);
            }
        }

        for(Integer val : set){
            ans.add(val);
        }
        return ans;
    }
}
