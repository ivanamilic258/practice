package org.example;

import java.text.MessageFormat;
import java.util.Arrays;

public class RearrangeArray {

//Problem: Rotate an array of n elements to the right by k steps. For example, with n
//= 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]. How many different
//ways do you know to solve this problem?

    public static void main(String[] args) {
        // Check if any arguments were passed
        if (args.length > 0) {
            System.out.println("Received arguments:");
            for (String arg : args) {
                System.out.println(arg);
            }
            String[] strArr = args[0].split(","); // Split the argument string into substrings based on commas
           int arrLength=Integer.parseInt(args[1]);
            int[] arr = new int[arrLength]; // Create an int array of the same length

            // Parse each substring into an integer
            for (int i = 0; i < arrLength; i++) {
                try {
                    arr[i] = Integer.parseInt(strArr[i]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format: " + strArr[i]);
                    return;
                }
            }

            int n = Integer.parseInt(args[1]);
            int k = Integer.parseInt(args[2]);


            int[] sol1 = solution1(arr, n, k);
            System.out.println("Solution 1");
            for (int na : sol1) {
                System.out.println(na);
            }

            int[] sol2 = solution2(arr, n, k);
            System.out.println("Solution 2");
            for (int na : sol2) {
                System.out.println(na);
            }

        } else {
            System.out.println("No arguments received.");
        }


    }

    private static int[] solution1(int[] arr, int n, int k){
//        translate

        int[] newArray=new int[n];
        for(int i = 0; i <n; i++) {
            if (i <= n - k - 1) {
                newArray[i + k] = arr[i];
            } else {
                newArray[i - n + k] = arr[i];
            }
        }
        return newArray;
    }
    private static int[] solution2(int[] arr, int n, int k){
//        Divide the array two parts: 1,2,3,4 and 5, 6

        int[] newArray=new int[n];
        int[] arr1 = Arrays.copyOfRange(arr, 0,n-k);
        int[] arr2 = Arrays.copyOfRange(arr, n-k,n);
       System.arraycopy(arr2,0,newArray,0, arr2.length);
       System.arraycopy(arr1,0,newArray,k, arr1.length);
        return newArray;
    }
}
