package Day5;

import java.util.Arrays;

public class Sort012 {
    public static void main(String[] args) {
        int[] arr = {1,1,0,2,1,0,2,0,2,0};
        sortColors(arr);
    }
    public static void sortColors(int[] arr) {
        int n = arr.length;
        int i=0,j=0,k=n-1;
        while(i<=k){
            if(arr[i]==0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            }
            else if(arr[i]==2){
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
                k--;
                //we will not increment i++ as we are not sure whats coming from k
            }
            else{
                i++;
            }
        }
        for(int val : arr){
            System.out.print(val+" ");
        }
    }
}
