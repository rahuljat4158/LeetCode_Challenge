package Day2;

import java.util.Scanner;

public class Smallest_Number {
    public static void main(String[] args) {
        //Smallest number k such that the product of digits of k is equal to n
        // This is T.C -> O(logN)
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
    public static int solution(int n){
        String ans = "";
        for(int div=9;div>=2;div--){
            while(n%div==0){
                n = n/div;
                ans = div + ans;
            }
        }
        if(n!=1){
            return -1;
        }
        else {
            return Integer.parseInt(ans);
        }
    }
}
