package Day2;

import java.util.Scanner;

public class Rotate_Matrix_90 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        int [][]mat=new int[n][m];
        for(int i=0;i<n;++i) {
            for (int j = 0; j < m; ++j) {
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.println();
        rotateBy90(mat);
        System.out.println('\n');
    }

    public static void rotateBy90(int [][]mat) {
        // Your code here
        int n = mat.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        for(int i=0;i<n;i++){
            int start = 0;
            int end = n-1;
            while(start<end){
                int temp = mat[i][start];
                mat[i][start] = mat[i][end];
                mat[i][end] = temp;
                start++;
                end--;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
