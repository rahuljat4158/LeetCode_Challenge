package Day3;

public class Minimum_in_sorted_rotated {

    //153. Find Minimum in Rotated Sorted Array
    //https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
    //Given an array arr which is sorted in ascending order
    //and contains n elements. Also, this array is rotated at some unknown point.
    //The task is to find the minimum element in it.

    public static void main(String[] args) {
        int[] arr = {5,6,7,8,9,1,2,3,4};
        System.out.println(MinElement(arr.length,arr));
    }

    static int MinElement(int n,int[] arr){
        //write code here
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            int mid = (left+right)/2;
            if(arr[mid]<arr[right]){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return arr[left];
    }
}
