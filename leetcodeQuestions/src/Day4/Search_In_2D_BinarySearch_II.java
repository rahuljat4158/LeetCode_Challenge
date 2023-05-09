package Day4;

public class Search_In_2D_BinarySearch_II {
    //240. Search a 2D Matrix II
    //https://leetcode.com/problems/search-a-2d-matrix-ii/description/

    //Write an efficient algorithm that searches for a value target in an
    //m x n integer matrix matrix. This matrix has the following properties:
    //Integers in each row are sorted in ascending from left to right.
    //Integers in each column are sorted in ascending from top to bottom.

    public static void main(String[] args) {
        int[][] arr = { {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(searchMatrix(arr,4));
        //System.out.println(searchMatrixBinary(arr,4));
    }

    //T.C -> O(m+n)
    public static boolean searchMatrix(int[][] arr, int x) {
        int i=0,j=arr[0].length-1;

        while(i<arr.length && j>=0){
            if(arr[i][j]==x){
                return true;
            }
            else if(arr[i][j]>x){
                j--;
            }
            else{
                i++;
            }
        }
        return false;
    }

    //T.C -> O(n*logm)
    public static boolean searchMatrixBinary(int[][] matrix, int target) {
        for(int i=0; i<matrix.length; i++){

            int start=0, end=matrix[i].length-1;
            while(start<=end){
                int middle =(start+end)/2;
                if(matrix[i][middle]==target){
                    return true;
                }
                if(matrix[i][middle]>target){
                    end=middle-1;
                }else{
                    start=middle+1;
                }
            }
        }
        return false;
    }
}
