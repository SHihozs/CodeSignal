## 38| growingPlant
Caring for a plant can be hard work, but since you tend to it regularly, you have a plant that grows consistently. Each day, its height increases by a fixed amount represented by the integer `upSpeed`.\
But due to lack of sunlight, the plant decreases in height every night, by an amount represented by `downSpeed`.\
Since you grew the plant from a seed, it started at height `0` initially.\
Given an integer `desiredHeight`, your task is to find how many days it'll take for the plant to reach this height.

#### Example
For `upSpeed = 100`, `downSpeed = 10`, and `desiredHeight = 910`,\
the output should be `solution(upSpeed, downSpeed, desiredHeight) = 10`.

| # | Day | Night |
|---| --- | ------|
|1	| 100 |	 90   |
|2	| 190 |	 180  |
|3	| 280 |	 270  |
|4  | 370 |	 360  |
|5	| 460 |	 450  |
|6	| 550 |	 540  |
|7	| 640 |	 630  |
|8	| 730 |	 720  |
|9	| 820 |	 810  |
|10 | 910 |	 900  |

The plant first reaches a height of `910` on day `10`.

#### Solution
```java
int solution(int upSpeed, int downSpeed, int desiredHeight) {
    
    int firstReach = 0;
    int result = 0;
    
    while(firstReach < desiredHeight){
    
        //DAY
        firstReach += upSpeed;
        result += 1;
        
        if(firstReach >= desiredHeight){
            break;
        }
        //NIGHT
        else{
            firstReach -= downSpeed;
        }
    }    
    return result;    
}
```

## 39| Knapsack Light
You found two items in a treasure chest! The first item weighs `weight1` and is worth `value1`, and the second item weighs `weight2` and is worth `value2`.\
What is the total maximum value of the items you can take with you, assuming that your max weight capacity is `maxW` and you can't come back for the items later?\
**Note that there are only two items and you can't bring more than one item of each type, i.e. you can't take two first items or two second items.**

#### Example
For `value1 = 10`, `weight1 = 5`, `value2 = 6`, `weight2 = 4`, and `maxW = 8`,\
the output should be `solution(value1, weight1, value2, weight2, maxW) = 10`. You can only carry the first item.

For `value1 = 10`, `weight1 = 5`, `value2 = 6`, `weight2 = 4`, and `maxW = 9`,\
the output should be `solution(value1, weight1, value2, weight2, maxW) = 16`. You're strong enough to take both of the items with you.

For `value1 = 5`, `weight1 = 3`, `value2 = 7`, `weight2 = 4`, and `maxW = 6`,\
the output should be `solution(value1, weight1, value2, weight2, maxW) = 7`. You can't take both items, but you can take any of them.

#### Solution
```java
int solution(int value1, int weight1, int value2, int weight2, int maxW) {
    
  int[] value  = {value1,value2};
  int[] weight = {weight1,weight2};
  int i = 0;

  return knapsack(value, weight, maxW, i);
}

int knapsack(int[] value, int[] weight, int maxW, int i){
    
    //BASE CASE
    if(i==2){
        return 0;
    }
    if(weight[i] > maxW)
    {
        return knapsack(value,weight,maxW,i+1);
    }
    else
    {
        return Math.max(knapsack(value, weight,maxW - weight[i],i+1) + value[i],knapsack(value, weight, maxW, i+1));
    }
    
}
```

## 40| longestDigitsPrefix
Given a string, output its longest prefix which contains only digits.

#### Example
For `inputString = "123aa1"`, the output should be `solution(inputString) = "123"`.

#### Solution
```java
String solution(String inputString) {
    
    String result = "";
    for(int i=0; i<inputString.length();i++){
        if(Character.isDigit(inputString.charAt(i))){
            result += inputString.charAt(i);
        }  
        else{
            return result;
        }
    }
    return result;
}
```

## 41| digitDegree
Let's define digit degree of some positive integer as the number of times we need to replace this number with the sum of its digits until we get to a one digit number.\
Given an integer, find its digit degree.

#### Example
For `n = 5`, the output should be `solution(n) = 0.`\
For `n = 100`, the output should be `solution(n) = 1`. `1 + 0 + 0 = 1`.\
For `n = 91`, the output should be `solution(n) = 2`. `9 + 1 = 10 -> 1 + 0 = 1`.

#### Solution
```java
int solution(int n) {
    
    //7+7+7+7+7+3 = 38(1) 3+8 11(2) 1+1(3)
    int count = 0;
    
    //CONVERT INT TO STRING
    String num = Integer.toString(n);
    
    while(num.length()>1){
        
        int sum   = 0;
        
        for(int i=0; i<num.length(); i++ ){
            sum   += Character.getNumericValue(num.charAt(i));
        }
        num    = Integer.toString(sum);
        count += 1;
        
    }
    return count;
}
```

## 42| Bishop and Pawn
Given the positions of a white `bishop` and a black `pawn` on the standard chess board, determine whether the bishop can capture the pawn in one move.\
The bishop has no restrictions in distance for each move, but is limited to diagonal movement. 

#### Example
For `bishop = "a1"` and `pawn = "c3"`, the output should be `solution(bishop, pawn) = true`.\
For `bishop = "h1"` and `pawn = "h3"`, the output should be `solution(bishop, pawn) = false`.

#### Solution
```java
boolean solution(String bishop, String pawn) {
    
     //CONVERT STRING TO INT(ASCII)
     int bishop_row  = (int)bishop.charAt(0) - 64 ; //A = 1
     int bishop_col  = bishop.charAt(1);
     
     int pawn_row  = (int)pawn.charAt(0) - 64 ; //A = 1
     int pawn_col  = pawn.charAt(1);
     
     //CALCULATE
     if(Math.abs(bishop_row - pawn_row) == Math.abs(bishop_col - pawn_col)){
         return true;
     }
     return false;
}
```

