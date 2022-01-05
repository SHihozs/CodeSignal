## 09| Reach Next Level
You are playing an RPG game. Currently your experience points (XP) total is equal to `experience`. To reach the next level your XP should be at least at `threshold`. If you kill the monster in front of you, you will gain more experience points in the amount of the `reward`.\
Given values `experience`, `threshold` and `reward`, check if you reach the next level after killing the monster.

#### Example
For `experience = 10`, `threshold = 15`, and `reward = 5`, the output should be `solution(experience, threshold, reward) = true`.\
For `experience = 10`, `threshold = 15`, and `reward = 4`, the output should be `solution(experience, threshold, reward) = false`.

#### Solution
```java
boolean solution(int experience, int threshold, int reward) {

    if(experience + reward >= threshold){
        return true;
    }
    return false;
}
```

## 10| Knapsack Light
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

## 11| Extra Number
You're given three integers, `a`, `b` and `c`. It is guaranteed that two of these integers are equal to each other. What is the value of the third integer?.

#### Example
For `a = 2`, `b = 7`, and `c = 2`, the output should be `solution(a, b, c) = 7`.\
The two equal numbers are `a` and `c`. The third number (`b`) equals `7`, which is the answer.

#### Solution
```java
int solution(int a, int b, int c) {
    
    if(a == b){
        return c;
    }else if(a == c){
        return b;
    }
    else return a;
    
    // return a^b^c;
}
```
