package Day2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Spiral_Matrix_II {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();

        int[][] ans = generateMatrix(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(ans[i][j]+" ");
            }
        }
        System.out.println('\n');
    }

    public static int[][] generateMatrix(int n) {
        int ans[][]=new int[n][n];
        int top = 0;
        int bot = n-1;
        int left = 0;
        int right = n-1;
        int dir = 0;
        int num = 1;

        while(top<=bot && left<=right){
            if(dir==0){
                for(int j=left;j<=right;j++){
                    ans[top][j]=num;
                    num++;
                }
                dir = 1;
                top++;
            }
            else if(dir==1){
                for(int i=top;i<=bot;i++){
                    ans[i][right]=num;
                    num++;
                }
                dir = 2;
                right--;
            }
            else if(dir==2){
                for(int j=right;j>=left;j--){
                    ans[bot][j]=num;
                    num++;
                }
                dir = 3;
                bot--;
            }
            else if(dir==3){
                for(int i=bot;i>=top;i--){
                    ans[i][left]=num;
                    num++;
                }
                dir = 0;
                left++;
            }
        }
        return ans;
    }
}
