package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        //int[] array = {6, 7, 7, 8, 7, 9};
        int[] array = {4, 4, 4, 4, 1, 1};
        //int[] array = {1, 1, 2, 2, 2, 3};

        /*
            1,1,1,2,2,3
            countdup = 3 --> 1 --> 2 -->
                 max = 3 --> 3 --> 3 --> 3
                 min = 3 --> 3 --> 3 --> 2
         */

        //SORTING
        int temp = 0;
        for (int i = 0; i<array.length; i++) {
            for(int j=i+1; j<array.length; j++){
                if(array[i] > array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        for(int a : array){
            System.out.println(a);
        }

        int count_duplicate = 1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i=0; i < array.length-1; i++) {

            if(array[i] == array[i+1]){
                count_duplicate++;
            }
            else{
                if(count_duplicate > max){
                    max = count_duplicate;
                }
                if(count_duplicate < min){
                    min = count_duplicate;
                }
                count_duplicate = 1;
            }
        }

        //CASE 1 1 4 4 4 4
        if(count_duplicate > max){
            max = count_duplicate;
        }
        if(count_duplicate < min){
            min = count_duplicate;
        }

        System.out.println(max-min);
    }

}//main

