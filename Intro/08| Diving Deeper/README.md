## 34| extractEachKth
Given array of integers, remove each kth element from it.

#### Example
For `inputArray = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]` and `k = 3`, the output should be `solution(inputArray, k) = [1, 2, 4, 5, 7, 8, 10]`.

#### Solution
```java
int[] solution(int[] inputArray, int k) {

    /*
        array    : [2, 4, 6, 8, 10]
        position :  1  2  3  4   5
        k: 2
        result   :  [2, 6, 10]
    
    */
    
    Queue<Integer> queue = new LinkedList<>();
    
    for(int i=0; i<inputArray.length; i++){
        if((i+1) % k != 0){
            queue.add(inputArray[i]);
        }
    }
    
    int[] result = new int[queue.size()];
    
    for(int i=0; i<result.length; i++){
        result[i] = queue.poll();
    }
    
    return result;
    
}
```

## 35| firstDigit
Find the leftmost digit that occurs in a given string.

#### Example
For `inputString = "var_1__Int"`, the output should be `solution(inputString) = '1'`.\
For `inputString = "q2q-q"`, the output should be `solution(inputString) = '2'`.\
For `inputString = "0ss"`, the output should be `solution(inputString) = '0'`.

#### Solution
```java
char solution(String inputString) {
    
    char result = 0;
    
    for(int i=0; i<inputString.length(); i++){
        
        if(Character.isDigit(inputString.charAt(i))){
            result = inputString.charAt(i);
            break;
        }
    }
    return result ;
}
```

## 36| differentSymbolsNaive
Given a string, find the number of different characters in it.

#### Example
For `s = "cabca"`, the output should be `solution(s) = 3`. There are `3` different characters `a`, `b` and `c`.

#### Solution
```java
int solution(String s) {
    
    Queue<Character> queue = new LinkedList<>();
    
    for(int i=0; i<s.length(); i++){
        if(!queue.contains(s.charAt(i))){
            queue.add(s.charAt(i));
        }
    }
    
    int count=0;
    while(!queue.isEmpty()){
        queue.poll();
        count += 1;
    }
    
    return count;

}
```

## 37| arrayMaxConsecutiveSum
Given array of integers, find the maximal possible sum of some of its k consecutive elements.

#### Example
For `inputArray = [2, 3, 5, 1, 6]` and `k = 2`, the output should be `solution(inputArray, k) = 8`.
All possible sums of `2` consecutive elements are:

`2 + 3 = 5`.\
`3 + 5 = 8`.\
`5 + 1 = 6`.\
`1 + 6 = 7`.

Thus, the answer is `8`.

#### Solution
```java
int solution(int[] inputArray, int k) {
    
    //if the value 'k' is higher then the loop for is lower
    
    int max =Integer.MIN_VALUE;
    
    for(int i=0; i<inputArray.length-(k-1); i++){
        
        int sum = 0;
        
        for(int j=i+1; j<(k+i); j++){
            
            sum += inputArray[j];
            
        }
        
        sum += inputArray[i];
        
        //CHECK MAX
        if(sum > max){
            max = sum;
        } 
    }
    return max;
}
```

