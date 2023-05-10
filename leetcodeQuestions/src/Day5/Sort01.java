package Day5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Sort01 {
    public static void main(String[] args) {
        int[] arr = {1,0,1,0,0,1,1,1,1,1,0};
        //System.out.println(Arrays.toString(Sorting01(arr.length,arr)));
        System.out.println(Arrays.toString(SinglePassSorting01(arr.length,arr)));
    }

    //It take to many pass
    static int[] Sorting01(int n,int[] arr){
        // Your code here
        int count0 = 0;
        int count1 = 0;
        for(int i=0;i<n;i++){
            if(arr[i]==0)
                count0++;
            else
                count1++;
        }
        int currindex = 0;
        for(int i=0;i<count0;i++){
            arr[currindex] = 0;
            currindex++;
        }
        for(int i=0;i<count1;i++){
            arr[currindex] = 1;
            currindex++;
        }
        return arr;
    }

    //Single Pass Approach
    static int[] SinglePassSorting01(int n,int[] arr){
        // Your code here
        int i=0,j=0;
        while(i<n){
            if(arr[i]==0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            }
            else{
                i++;
            }
        }
        return arr;
    }
}
