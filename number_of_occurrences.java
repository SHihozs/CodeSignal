package com.company;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Main {

    /* 2. print each item and its number of occurrences
        Example: [2,2,1,3,5,4] --> 2:2, 1:1, 3:1, 5:1, 4:1

     */

    public static void main(String[] args) {
	// write your code here

    int [] array = {2,2,1,3,5,4};

    HashMap<Integer,Integer> map = new HashMap<>();
    int count = 1;
    int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
             if(!map.containsKey(array[i])){
                 map.put(array[i],count);
             }
             else{
                int getValue = map.get(array[i]); //get return valued
                getValue++;
                map.put(array[i],getValue);
             }
        }

        for (Map.Entry<Integer,Integer> m : map.entrySet()){
            System.out.println(m.getKey() + ":" + m.getValue());
        }
    }
}
