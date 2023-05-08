package Day3;

public class Minimum_in_sorted_rotated_LeetCodeHard154 {

    //154. Find Minimum in Rotated Sorted Array II
    //https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
    //This is same as find minimum in sorted rotated with few changes
    //Given the sorted rotated array nums that may contain duplicates,
    //return the minimum element of this array.
    //You must decrease the overall operation steps as much as possible.
    public static void main(String[] args) {
        int[] arr = {5,6,7,8,9,1,2,3,4};
        System.out.println(MinElement(arr));
    }

    static int MinElement(int[] arr){
        //write code here
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            int mid = (left+right)/2;
            if(arr[mid]<arr[right]){
                right = mid;
            }
            else if(arr[mid]>arr[right]){
                left = mid+1;
            }
            else{
                right--;
            }
        }
        return arr[left];
    }
}
