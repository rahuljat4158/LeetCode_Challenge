package Day3;

public class First_Last_Index_BinarySearch {
    public static void main(String[] args) {

        //34. Find First and Last Position of Element in Sorted
        //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
        //Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
        //If target is not found in the array, return [-1, -1].
        //You must write an algorithm with O(log n) runtime complexity.

        int[] arr = {1,1,2,2,4,4,4,4,4,4,6,8,9,9};
        int[] ans = new int[2];
        ans = searchRange(arr,4);
        System.out.println(ans[0]+" "+ans[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int fo = firstOcc(nums,nums.length,target);
        int lo = lastOcc(nums,nums.length,target);

        return new int[]{fo,lo};
    }
    static int firstOcc(int[] arr,int n,int target){
        int si = 0;
        int ei = n-1;
        int pans = -1;
        while(si<=ei){
            int mid = (si+ei)/2;
            if(arr[mid]==target){
                pans = mid;
                //but also try to find in left to find smaller index
                //or first occurence
                ei = mid-1;
            }
            else if(arr[mid]>target){
                ei = mid-1;
            }
            else{
                si = mid+1;
            }
        }
        return pans;
    }
    static int lastOcc(int[] arr,int n,int target){
        int si = 0;
        int ei = n-1;
        int pans = -1;
        while(si<=ei){
            int mid = (si+ei)/2;
            if(arr[mid]==target){
                pans = mid;
                //but also try to find in right to greater smaller index
                //or last occurence
                si = mid+1;
            }
            else if(arr[mid]>target){
                ei = mid-1;
            }
            else{
                si = mid+1;
            }
        }
        return pans;
    }
}
