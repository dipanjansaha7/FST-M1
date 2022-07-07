package activities;

import java.util.*;
// In this activity, we are writing a program to check if the sum of all the 10's in the array is exactly 30.

public class Activity2 {
    public static void main(String[] Args){
        int[] numArr = {10,77,10,54,-11,10,10};
        int result;
        System.out.println("Original Array: " + Arrays.toString(numArr));
        result = search(numArr,10,30);
        switch(result){
            case 30:
                System.out.println("Success!!! The sum of all the 10's in the array is exactly 30");
                break;
            default:
                System.out.println("Failure :-( The sum of all the 10's in the array is: "+result+", which is not exactly equal to 30!!!");
        }
    }
    public static int search(int[] numArr1,int a,int b){
        int sum=0;

        for(int i : numArr1){
            if(i==10){
                sum+=i;
            }
        }
        return(sum);
    }
}
