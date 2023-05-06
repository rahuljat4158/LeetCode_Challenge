package Day1;
import java.util.*;
public class ThreeSum {
    //brute force approach is by using 3 for loop TC -> O(n^3)

    //efficient approach T.C -> O(N^2)

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int j, k, sum;
        for(int i=0;i<nums.length-2;i++){
            j = i+1;
            k = nums.length - 1;
            while(j<k){
                //System.out.println("Checking " + nums[i] + " , " + nums[j] + ",
                //" + nums[k]);
                sum = nums[i] + nums[j] + nums[k];
                if (sum == 0){
                    List<Integer> ls = new ArrayList<Integer>();
                    ls.add(nums[i]);
                    ls.add(nums[j]);
                    ls.add(nums[k]);
                    res.add(ls);
                    j++;k--;
                    while(j<k && nums[k]==nums[k+1]) k--;//to avoid duplicates
                    while(j<k && nums[j]==nums[j-1]) j++;//to avoid duplicates
                } else if (sum > 0){
                    k--;
                    while(j<k && nums[k]==nums[k+1]) k--;//optional skip for
                    //non-zero triplets
                } else {//
                    j++;
                    while(j<k && nums[j]==nums[j-1]) j++;//optional skip for
                    //non-zero triplets
                }
            }
            while(i<nums.length-2 && nums[i]==nums[i+1]){ //to avoid duplicates
                i++;
            }
        }
        return res;
    }
}

