## 09| All Longest Strings
Given an array of strings, return another array containing all of its longest strings.

#### Example
For `inputArray = ["aba", "aa", "ad", "vcd", "aba"]`, the output should be `solution(inputArray) = ["aba", "vcd", "aba"]`.

#### Solution
```java
String[] solution(String[] inputArray) {
    
     int max =Integer.MIN_VALUE;
     int count = 0;
     
     for(int i=0; i<inputArray.length; i++){
        
        if(inputArray[i].length() > max){
            max = inputArray[i].length();
            count = 1;
        }
        
        else if(inputArray[i].length() == max){
            count++;
        } 
     } 
    
     String [] result = new String[count];   
     int j = 0;
     
     for(int i=0; i<inputArray.length; i++){

         if(inputArray[i].length() == max){
             result[j] = inputArray[i];
             j++;
         }
     } 
    
    return result;      
}
```

## 10| commonCharacterCount
Given two strings, find the number of common characters between them.

#### Example
For `s1 = "aabcc"` and `s2 = "adcaa"`, the output should be `solution(s1, s2) = 3`. Strings have `3` common characters - `2` "a"s and `1` "c".

#### Solution
```java
int solution(String s1, String s2) {

int sum = 0;

    for(int i=0; i<s1.length(); i++){
     
        for(int j=0; j<s2.length(); j++){
         
             if(s1.charAt(i) == s2.charAt(j)){
                 sum += 1;
                 s2 = s2.replaceFirst(String.valueOf(s2.charAt(j)),"*");
                 break;
             }  
        }   
    }
    return sum;
}
```

## 11| isLucky
Ticket numbers usually consist of an even number of digits. A ticket number is considered lucky if the sum of the first half of the digits is equal to the sum of the second half.\
Given a ticket number `n`, determine if it's lucky or not.

#### Example
For `n = 1230`  , the output should be `solution(n) = true`.\
For `n = 239017`, the output should be `solution(n) = false`.

#### Solution
```java
boolean solution(int n) {
    
    String convert = String.valueOf(n);
    
    int first = 0;
    int end   = 0;
    
    for(int i=0, j=convert.length()-1; i<convert.length()/2; i++,j--){
         first += Character.getNumericValue(convert.charAt(i));
         end   += Character.getNumericValue(convert.charAt(j));
    }
    
    if(first == end){
        return true;
    }
       
    return false;
}
```

## 12| Sort by Height
Some people are standing in a row in a park. There are trees between them which cannot be moved. Your task is to rearrange the people by their heights in a non-descending order without moving the trees. People can be very tall!

#### Example
For `a = [-1, 150, 190, 170, -1, -1, 160, 180]`, the output should be `solution(a) = [-1, 150, 160, 170, -1, -1, 180, 190]`.

#### Solution
```java
int[] solution(int[] a) {
    
    int temp = 0;
    
    for(int i=0; i<a.length; i++){
        for(int j=i+1; j<a.length; j++){
            if(a[i] == -1){
                a[i] = a[i];
                break;
            }
            else{
                if(a[i] > a[j] && a[j] != -1){
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;       
                }
                else{
                    a[i] = a[i];
                }
            }
        }
    }
    return a;
}
```

## 13| reverseInParentheses
Write a function that reverses characters in (possibly nested) parentheses in the input string. Input strings will always be well-formed with matching `()`s.

#### Example
For `inputString = "(bar)"`, the output should be `solution(inputString) = "rab"`.\
For `inputString = "foo(bar)baz"`, the output should be `solution(inputString) = "foorabbaz"`.\
For `inputString = "foo(bar)baz(blim)"`, the output should be `solution(inputString) = "foorabbazmilb"`.\
For `inputString = "foo(bar(baz))blim"`, the output should be `solution(inputString) = "foobazrabblim"`. Because `"foo(bar(baz))blim"` becomes `"foo(barzab)blim"` and then `"foobazrabblim"`.

#### Solution
```java
String solution(String inputString) {
    
Stack<Character> stack = new Stack<>();
StringBuilder rev = new StringBuilder();

    for(int i=0; i<inputString.length();i++){
        if(inputString.charAt(i) != ')'){
            stack.push(inputString.charAt(i));
        }
        else{
            while(stack.peek() != '('){
               rev.append(stack.pop());
            }
            stack.pop(); //POP '('
    
            //REV TO STACK
            for(int j=0; j<rev.length(); j++){
                stack.push(rev.charAt(j));
            }     
            rev.setLength(0); //CLEAR REV
        }
    }
    
StringBuilder result = new StringBuilder();
    
    //STACK [FILO] TO STRING 
    while(!stack.isEmpty()){
        result.append(stack.pop());
    }
    //REVERSE WHEN POP FROM STACK
    result.reverse(); 
    
    return result.toString();
}
```
