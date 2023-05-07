package Day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Spiral_Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        int [][]mat=new int[n][m];
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                mat[i][j]=sc.nextInt();
            }
        }

        List<Integer> ans = spiralOrder(mat);
        for(int val : ans){
            System.out.print(val+" ");
        }
        System.out.println('\n');
    }

    public static List<Integer> spiralOrder(int[][] mat) {

        List<Integer> ans = new ArrayList<>();
        int m = mat.length;
        int n = mat[0].length;
        int top = 0;
        int bot = m-1;
        int left = 0;
        int right = n-1;
        int dir = 0;

        while(top<=bot && left<=right){
            if(dir==0){
                for(int j=left;j<=right;j++){
                    ans.add(mat[top][j]);
                }
                dir = 1;
                top++;
            }
            else if(dir==1){
                for(int i=top;i<=bot;i++){
                    ans.add(mat[i][right]);
                }
                dir = 2;
                right--;
            }
            else if(dir==2){
                for(int j=right;j>=left;j--){
                    ans.add(mat[bot][j]);
                }
                dir = 3;
                bot--;
            }
            else if(dir==3){
                for(int i=bot;i>=top;i--){
                    ans.add(mat[i][left]);
                }
                dir = 0;
                left++;
            }
        }
        return ans;
    }
}
