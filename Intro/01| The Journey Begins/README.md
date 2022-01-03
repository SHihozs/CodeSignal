## 01| ADD
Write a function that returns the sum of two numbers.

#### Example
For `param1 = 1` and `param2 = 2`, the output should be `solution(param1, param2) = 3`.

#### Solution
```java
int solution(int param1, int param2) {
    return param1+param2; 
}
```

## 02| centuryFromYear
Given a year, return the century it is in. The first century spans from the year 1 up to and including the year 100, the second - from the year 101 up to and including the year 200, etc.

#### Example
For `year = 1905`, the output should be `solution(year) = 20`.\
For `year = 1700`, the output should be `solution(year) = 17`.

#### Solution
```java
int solution(int year) {
    if(year%100 != 0){
        return (year/100)+1;
    }
    else{
        return year/100;
    } 
} 
```

## 03| checkPalindrome
Given the string, check if it is a palindrome.

#### Example
For `inputString = "aabaa"`, the output should be `solution(inputString) = true`.\
For `inputString = "abac"`, the output should be `solution(inputString) = false`.\
For `inputString = "a"`, the output should be `solution(inputString) = true`.

#### Solution
```java
boolean solution(String inputString) {
    
    boolean check_palindrome = true;
    
    if(inputString.length() == 1){
        check_palindrome = true;
    }
    else{
        for(int i=0; i<inputString.length(); i++){
            if(inputString.charAt(i) != inputString.charAt(inputString.length() - (i+1))){
                check_palindrome = false;
            }
        }
    }
    
    return check_palindrome;
}

```
