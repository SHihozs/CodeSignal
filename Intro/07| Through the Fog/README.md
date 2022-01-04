## 30| Circle of Numbers
Consider integer numbers from `0` to `n - 1` written down along the circle in such a way that the distance between any two neighboring numbers is equal (note that `0` and `n - 1` are neighboring, too).

Given `n` and `firstNumber`, find the number which is written in the radially opposite position to `firstNumber`.

#### Example
For `n = 10` and `firstNumber = 2`, the output should be `solution(n, firstNumber) = 7`.

#### Solution
```java
int solution(int n, int firstNumber) {
    
    //if n=? then the result far from first number n/2
    
    if(firstNumber > n/2){
        return firstNumber - (n/2);
    }
    else if(firstNumber == n/2){
        return 0;
    }
    else{
        return firstNumber + (n/2);
    }     
}
```

## 31| depositProfit
You have deposited a specific amount of money into your bank account. Each year your balance increases at the same growth `rate`.\
With the assumption that you don't make any additional deposits, find out how long it would take for your balance to pass a specific `threshold`.

#### Example
For `deposit = 100`, `rate = 20`, and `threshold = 170`, the output should be `solution(deposit, rate, threshold) = 3`.\
Each year the amount of money in your account increases by `20%`. So throughout the years, your balance would be:

year 0: `100`.\
year 1: `120`.\
year 2: `144`.\
year 3: `172.8`.\
Thus, it will take `3` years for your balance to pass the `threshold`, so the answer is `3`.

#### Solution
```java
int solution(int deposit, int rate, int threshold) {
    
    int   year  = 0;
    float money = (float)deposit;
    float f_rate = (float)rate/100;
    
    while(money<threshold){
        money   = money+(money*f_rate);
        year += 1;
    }
    
    return year;
}
```

## 32| absoluteValuesSumMinimization
Given a sorted array of integers `a`, your task is to determine which element of `a` is closest to all other values of `a`.\
In other words, find the element `x` in `a`, which minimizes the following sum:

`abs(a[0] - x) + abs(a[1] - x) + ... + abs(a[a.length - 1] - x)` (where `abs` denotes the absolute value)

If there are several possible answers, output the **smallest** one.

#### Example
For `a = [2, 4, 7]`, the output should be `solution(a) = 4`.\
for `x = 2`, the value will be `abs(2 - 2) + abs(4 - 2) + abs(7 - 2) = 7`.\
for `x = 4`, the value will be `abs(2 - 4) + abs(4 - 4) + abs(7 - 4) = 5`.\
for `x = 7`, the value will be `abs(2 - 7) + abs(4 - 7) + abs(7 - 7) = 8`.\
The lowest possible value is when `x = 4`, so the answer is `4`.

For `a = [2, 3]`, the output should be `solution(a) = 2`.\
for `x = 2`, the value will be `abs(2 - 2) + abs(3 - 2) = 1`.\
for `x = 3`, the value will be `abs(2 - 3) + abs(3 - 3) = 1`.\
Because there is a tie, the smallest `x` between `x = 2` and `x = 3` is the answer.

#### Solution
```java
int solution(int[] a) {
    
    int min    = Integer.MAX_VALUE;
    int result = 0;
    
    for(int i=0; i<a.length; i++){
  
        int sum = 0;
        
        for(int j=0; j<a.length; j++){
            
            sum += Math.abs(a[j]-a[i]);
            
        }
        
        if(sum < min){
            min = sum;
            result = a[i];   
        }  
    }
    return result;
}  
```

## 33| stringsRearrangement
Given an array of equal-length strings, you'd like to know if it's possible to rearrange the order of the elements in such a way that each consecutive pair of strings differ by exactly one character. Return `true` if it's possible, and `false` if not.
**Note: You're only rearranging the order of the strings, not the order of the letters within the strings!**

#### Example
For `inputArray = ["aba", "bbb", "bab"]`, the output should be `solution(inputArray) = false`.\
There are 6 possible arrangements for these strings:

`["aba", "bbb", "bab"]`\
`["aba", "bab", "bbb"]`\
`["bbb", "aba", "bab"]`\
`["bbb", "bab", "aba"]`\
`["bab", "bbb", "aba"]`\
`["bab", "aba", "bbb"]`

None of these satisfy the condition of consecutive strings differing by 1 character, so the answer is `false`.

For `inputArray = ["ab", "bb", "aa"]`, the output should be `solution(inputArray) = true`.\
It's possible to arrange these strings in a way that each consecutive pair of strings differ by 1 character\
(eg: `"aa", "ab", "bb" or "bb", "ab", "aa"`), so return `true`.

#### Solution
```java
boolean solution(String[] inputArray) {
   
    boolean[] keeps = new boolean[inputArray.length];
    findSequence(inputArray, null, keeps, 0);
    return pass;
}
boolean pass = false; 

boolean diffOne(String s1, String s2) {
    int diff = 0;
    for (int j = 0 ; j < s1.length() ; j++) {
        if (s1.charAt(j) != s2.charAt(j)) {
            diff++;
            if (diff > 1) {
                return false;
            }
        }
    }
    return diff == 1;
}

void findSequence (String[] a, String prev, boolean[] keeps, int n) {
    if (n == a.length) {
        pass = true;
        return;
    }
    for (int i = 0; i < a.length; i++) {
        if (!keeps[i] && (prev == null || diffOne(prev, a[i]))) {
            keeps[i] = true;
            findSequence(a, a[i], keeps, n+1);
            keeps[i] = false;
        }
    }
}
```

