package com.example.retrofit;

public class soort {
    public static void main(String[] args) {
        int[] arr = { 6, 3, 1, 10, 9, 2 };

        int min = 0;

        int i, j;

        for (i = 0; i < arr.length; i++) {
            for (j = i; j < arr.length; j++) {
                if (arr[min] > arr[j])
                    min = j;
            }
            int temp = arr[min];
            arr[min] = arr[j];
            arr[j] = temp;
        }

        for (i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }
}
