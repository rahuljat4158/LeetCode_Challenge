package Day4;

public class Search_In_2D_BinarySearch {

    //74. Search a 2D Matrix
    //https://leetcode.com/problems/search-a-2d-matrix/description/

    //You are given an m x n integer matrix matrix with the following
    //two properties: Each row is sorted in non-decreasing order.
    //The first integer of each row is greater than the last integer
    //of the previous row. Given an integer target,
    //return true if target is in matrix or false otherwise.
    //You must write a solution in O(log(m * n)) time complexity.

    public static void main(String[] args) {
        int[][] arr = { {1,2,3},
                        {4,5,6},
                        {7,8,9}
                      };
        //System.out.println(searchMatrix(arr,4));
        System.out.println(searchMatrixBinary(arr,4));
    }

    //Method 1:

    //We can solve it by Brute force by traversing all element
    //T.C -> O(n*m)
    //Optimize brute force is with T.C -> O(n+m)
    public static boolean searchMatrix(int[][] arr, int x) {
        int i=0,j=arr[0].length-1;

        while(i<arr.length && j>=0){
            if(arr[i][j]==x){
                return true;
            }
            else if(arr[i][j]<x){
                i++;
            }
            else{
                j--;
            }
        }
        return false;
    }

    //Method 2:

    //we can apply binary search and reduce its T.C -> O(log(n*m)) , S.C -> O(1)
    public static boolean searchMatrixBinary(int[][] arr, int x) {

        //apply binary search in last column
        int n=arr.length;
        int m=arr[0].length;
        int si = 0;
        int ei = n-1;
        int prow = -1;
        while(si<=ei){
            int mid = (si+ei)/2;
            if(arr[mid][m-1]==x){
                return true;
            }
            else if(arr[mid][m-1]<x){
                si = mid+1;
            }
            else{
                prow = mid;
                ei = mid-1;
            }
        }

        //if no potential ans directly return false
        if(prow==-1){
            return false;
        }

        //after getting potential answer apply binary search in pans row
        si = 0;
        ei = m-1;
        while(si<=ei){
            int mid = (si+ei)/2;
            if(arr[prow][mid]==x){
                return true;
            }
            else if(arr[prow][mid]<x){
                si = mid+1;
            }
            else{
                ei = mid-1;
            }
        }
        return false;
    }
}
