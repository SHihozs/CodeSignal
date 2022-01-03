## 14| alternatingSums
Several people are standing in a row and need to be divided into two teams. The first person goes into **team 1**, the second goes into **team 2**, the third goes into **team 1** again, the fourth into **team 2**, and so on.\
You are given an array of positive integers - the weights of the people. Return an array of two integers, where the first element is the total weight of **team 1**, and the second element is the total weight of **team 2** after the division is complete.

#### Example
For `a = [50, 60, 60, 45, 70]`, the output should be `solution(a) = [180, 105]`.

#### Solution
```java
int[] solution(int[] a) {
    
int [] team= new int[2];

    for(int i=0; i<a.length; i++){
        if(i % 2 == 0){
            team[0] += a[i];
        }
        else{
            team[1] += a[i];
        }
    }
    return team;
}
```

## 15| Add Border
Given a rectangular matrix of characters, add a border of asterisks`(*)` to it.

#### Example
For` picture =  ["aa", 
                "++", 
                "zz"]`

the output should be `solution(picture) = ["++++",
                                           "+aa+", 
                                           "++++", 
                                           "+zz+", 
                                           "++++"]`
                                          
**note** : In example change `'+'` to `'*'`

#### Solution
```java
String[] solution(String[] picture) {
    
    Deque<String> deque  = new ArrayDeque<>();
    
    for(String s : picture){
        deque.add('*' + s + '*');
    }
    
    //LENGHT (*abc* = 5)
    int count =  deque.peekFirst().length();
    String asterisk = "";
    
    for(int i=0; i<count; i++){
       asterisk += "*";
    }
    
    deque.addFirst(asterisk);
    deque.addLast(asterisk);
    
    String[] result = new String[deque.size()];
    int i=0;
    
    while(!deque.isEmpty()){
        result[i] = deque.poll();
        i++;
    }
    
    return result;
}
```

## 16| Are Similar?
Two arrays are called similar if one can be obtained from another by swapping at most one pair of elements in one of the arrays.\
Given two arrays `a` and `b`, check whether they are similar.

#### Example
For `a = [1, 2, 3]` and `b = [1, 2, 3]`, the output should be `solution(a, b) = true`. The arrays are equal, no need to swap any elements.\
For `a = [1, 2, 3]` and `b = [2, 1, 3]`, the output should be `solution(a, b) = true`. We can obtain `b` from `a` by swapping `2` and `1` in `b`.\
For `a = [1, 2, 2]` and `b = [2, 1, 1]`, the output should be `solution(a, b) = false`. Any swap of any two elements either in `a` or in `b` won't make `a` and `b` equal.

#### Solution
```java
boolean solution(int[] a, int[] b) {
    
    /*
        [1,2,3]
        [2,1,3]
        
        i=0 sum = 1
        i=1 sum = 2
        i=2 sum = 2
    */
    
    int sum = 0;
    for (int i = 0; i < a.length; i++) {
        
        //IF INDEX a[i] != INDEX b[i]
        if(a[i] != b[i]){
           
            sum++;
        }
    } 
    
    Arrays.sort(a);
    Arrays.sort(b);
    
    if(Arrays.equals(a, b) && sum < 3){
        return true;
    }
    
    return false;
}
    
```

## 17| arrayChange
You are given an array of integers. On each move you are allowed to increase exactly one of its element by one. Find the minimal number of moves required to obtain a strictly increasing sequence from the input.

#### Example
For `inputArray = [1, 1, 1]`, the output should be `solution(inputArray) = 3`.

#### Solution
```java
int solution(int[] inputArray) {
    
    /*
        [1,1,1] --> minimum should --> [1,1+1,1+1+1] --> count (+1) = 3
    */
    
    int count = 0;
    for(int i=0; i<inputArray.length-1; i++){
        
        while(inputArray[i+1] <= inputArray[i]){
            count += 1;
            inputArray[i+1] += 1;
        }
    }
    return count;
}
```

## 18| palindromeRearranging
Given a string, find out if its characters can be rearranged to form a **palindrome**.

#### Example
For `inputString = "aabb"`, the output should be `solution(inputString) = true`.\
We can rearrange `"aabb"` to make `"abba"`, which is a palindrome.

#### Solution
```java
boolean solution(String inputString) {

    HashMap<Character,Integer> hash = new HashMap<>();
    int count = 1;
    int value = 0;
    
    for(int i=0; i<inputString.length(); i++){
        
        if(!hash.containsKey(inputString.charAt(i))){
            
            hash.put(inputString.charAt(i),count); 
        }
        else{
            value = hash.get(inputString.charAt(i));
            value += 1;
            hash.put(inputString.charAt(i),value);
        }   
    }
    
    int odd = 0;
    for(Map.Entry<Character,Integer> m : hash.entrySet()){
        if(m.getValue() % 2 != 0){
            odd += 1;
        }
    }
    
    //NOT PALINDROME
    if(odd > 1){
        return false;
    }
    //PALINDREOME
    else{
        return true;
    }
}
```
