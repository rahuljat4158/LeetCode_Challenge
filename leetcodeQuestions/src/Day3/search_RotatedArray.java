package Day3;

public class search_RotatedArray {

    //(LeetCode)33. Search in Rotated Sorted Array
    //https://leetcode.com/problems/search-in-rotated-sorted-array/description/
    //Given the array nums after the possible rotation and an integer target,
    //return the index of target if it is in nums, or -1 if it is not in nums.
    //You must write an algorithm with O(log n) runtime complexity.

    public static void main(String[] args) {
        int[] arr = {5,6,7,8,9,1,2,3,4};
        System.out.println(search(arr,7));
    }
    public static int search(int[] a, int target) {
        int si = 0;
        int ei = a.length-1;
        while(si<=ei){
            int mid = (si+ei)/2;
            if(a[mid]==target){
                return mid;
            }
            else if(a[si]<=a[mid]){
                //left part sorted
                if(target>=a[si] && target<=a[mid]){
                    ei = mid-1;
                }
                else{
                    si = mid+1;
                }
            }
            else{
                //right part is sorted
                if(target>=a[mid] && target<=a[ei]){
                    si = mid+1;
                }
                else{
                    ei = mid-1;
                }
            }
        }
        return -1;
    }
}
