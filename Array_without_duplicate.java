package com.company;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

     /*
     1. return a new Array without duplications
    Example: [2,2,1,3,5,4,2] --> [2,1,3,5,4]
     */

    public static Integer[] solution(int[] array){

        HashSet<Integer> hash = new HashSet();

        for (int i = 0; i < array.length; i++) {
            hash.add(array[i]);
        }

        Integer[] result = hash.toArray(new Integer[hash.size()]);
        return result;
    }

    public static int[] queue(int[] array){
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            if(!queue.contains(array[i]))
            queue.add(array[i]);
        }

        int [] result = new int[queue.size()];
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            result[i] = queue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        // write your code here
        int array[] = {2, 2, 1, 3, 5, 4, 2};

       /* Integer[] output = solution(array);

        for (Integer i: output) {
            System.out.println(i);
        }
       */

        int[] output_queue = queue(array);
        for (int i: output_queue) {
            System.out.println(i);
        }
    }
}
