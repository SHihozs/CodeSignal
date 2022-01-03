## 04| adjacentElementsProduct
Given an array of integers, find the pair of adjacent elements that has the largest product and return that product.

#### Example
For `inputArray = [3, 6, -2, -5, 7, 3]`, the output should be `solution(inputArray) = 21`. `7` and `3` produce the largest product.

#### Solution
```java
int solution(int[] inputArray) {
    
    int max = Integer.MIN_VALUE;
    
    for(int i=0; i<inputArray.length-1;i++){       //protect index out of bound
        if(inputArray[i] * inputArray[i+1]>max){
            max = inputArray[i]*inputArray[i+1];       
        }       
    }
    return max;
}
```

## 05| shapeArea
Below we will define an `n`-interesting polygon. Your task is to find the area of a polygon for a given `n`.

A `1`-interesting polygon is just a square with a side of length 1. An `n`-interesting polygon is obtained by taking the `n - 1`-interesting polygon and appending `1`-interesting polygons to its rim, side by side. 

#### Example
For `n = 2`, the output should be `solution(n) = 5`.\
For `n = 3`, the output should be `solution(n) = 13`.

#### Solution
```java
int solution(int n) {
    if(n!=0){
        return (n*n) + ((n-1)*(n-1)) ; 
    }
    
    else return 0;
     
}
```

## 06| Make Array Consecutive 2
Ratiorg got `statues` of different sizes as a present from CodeMaster for his birthday, each statue having an non-negative integer size. Since he likes to make things perfect, he wants to arrange them from smallest to largest so that each statue will be bigger than the previous one exactly by `1`. He may need some additional statues to be able to accomplish that. Help him figure out the minimum number of additional statues needed.

#### Example
For `statues = [6, 2, 3, 8]`, the output should be `solution(statues) = 3`. Ratiorg needs statues of sizes 4, 5 and 7.

#### Solution
```java
int solution(int[] statues) {
    Arrays.sort(statues); 
    int result = 0;
    
    for(int i=0; i<statues.length-1; i++){
        if(statues[i+1] - statues[i] > 1){
            result += (statues[i+1] - statues[i])-1;
        }
    }
    return result;
}
```

## 07| almostIncreasingSequence
Given a sequence of integers as an array, determine whether it is possible to obtain a strictly increasing sequence by removing no more than one element from the array.\
Note: sequence `a0`, `a1`, ..., `an` is considered to be a strictly increasing if `a0 < a1 < ... < an`. Sequence containing only one element is also considered to be strictly increasing.

For `sequence = [1, 3, 2, 1]`, the output should be `solution(sequence) = false`.\
There is no one element in this array that can be removed in order to get a strictly increasing sequence.

For `sequence = [1, 3, 2]`, the output should be `solution(sequence) = true`.\
You can remove `3` from the array to get the strictly increasing sequence `[1, 2]`. Alternately, you can remove `2` to get the strictly increasing sequence `[1, 3]`.

#### Solution
```java
boolean solution(int[] sequence) {
    
 int removed = 0;
 int max = Integer.MIN_VALUE;
 int prev_max = max;
 
 for(int i=0; i<sequence.length; i++){
    
    //BEST CASE
    if(sequence[i] > max){
        prev_max = max;
        max      = sequence[i];
    }
    
    //REMOVE_ONE
    else if(sequence[i] > prev_max){
        removed++;
        max = sequence[i];
    }
    
    //CHECK_TWO
    else{
        removed++;
    }
    
    //IF REMOVE MORE THAN ONE TIME
    if(removed > 1){
        return false;
    }
 }
 return true; //ex. 1 3 2 4
    
}


/*
    1 3 2 1

i=0
1>-100000
pre = -100000
max = 1

i=1
3>1(max)
pre = 1 // because 1 greater than 3 only
max = 3

i=2
2>1(pre)
remove = 1
max    = 2

i=3
remove = 2

thus false
    
    
    */

```

## 08| matrixElementsSum
After becoming famous, the CodeBots decided to move into a new building together. Each of the rooms has a different cost, and some of them are free, but there's a rumour that all the free rooms are haunted! Since the CodeBots are quite superstitious, they refuse to stay in any of the free rooms, **or any of the rooms below any of the free rooms.**\

Given `matrix`, a rectangular matrix of integers, where each value represents the cost of the room, your task is to return the total sum of all rooms that are suitable for the CodeBots (ie: add up all the values that don't appear below a `0`).

#### Example
For
`matrix = [[0, 1, 1, 2], 
          [0, 5, 0, 0], 
          [2, 0, 3, 3]]`
the output should be `solution(matrix) = 9`.\
There are several haunted rooms, so we'll disregard them as well as any rooms beneath them. Thus, the answer is `1 + 5 + 1 + 2 = 9`.

For
`matrix = [[1, 1, 1, 0], 
          [0, 5, 0, 1], 
          [2, 1, 3, 10]]`
the output should be `solution(matrix) = 9`.\
Note that the free room in the final column makes the full column unsuitable for bots (not just the room directly beneath it). Thus, the answer is `1 + 1 + 1 + 5 + 1 = 9`.

#### Solution
```java
int solution(int[][] matrix) {
int sum = 0;

      //i = column & j = row
      for(int i=0; i<matrix[0].length; i++){     
          for(int j=0; j<matrix.length;j++){
              //CHOOSE VERTICAL ROW
              if(matrix[j][i] == 0){
                  break;
              }
              else{
                  sum += matrix[j][i];
              }
          }
      }
      
      return sum;  
}
```
