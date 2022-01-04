## 25| Array Replace
Given an array of integers, replace all the occurrences of `elemToReplace` with `substitutionElem`.

#### Example
For `inputArray = [1, 2, 1]`, `elemToReplace = 1`, and `substitutionElem = 3`.\
the output should be `solution(inputArray, elemToReplace, substitutionElem) = [3, 2, 3]`.

#### Solution
```java
int[] solution(int[] inputArray, int elemToReplace, int substitutionElem) {

    for(int i=0; i<inputArray.length; i++){
        if(inputArray[i] == elemToReplace){
            inputArray[i] = substitutionElem;
        }
    }
    return inputArray;
}
```

## 26| evenDigitsOnly
Check if all digits of the given integer are even.

#### Example
For `n = 248622`, the output should be `solution(n) = true`.
For `n = 642386`, the output should be `solution(n) = false`.

#### Solution
```java
boolean solution(int n) {
    
    //COVNERT INT TO STRING
    String s = Integer.toString(n);
    
    for(int i=0; i<s.length(); i++){
        if(Character.getNumericValue(s.charAt(i)) % 2 != 0){
            return false;
        }
    }
    return true;
}
```

## 27| variableName
Correct variable names consist only of English letters, digits and underscores and they can't start with a digit.\
Check if the given string is a correct variable name.

#### Example
For `name = "var_1__Int"`, the output should be `solution(name) = true`.\
For `name = "qq-q"`, the output should be `solution(name) = false`.\
For `name = "2w2"`, the output should be `solution(name) = false`.

#### Solution
```java
boolean solution(String name) {
    
    //CHECK NUMERIC VALUE FOR FIRST INDEX
    if(Character.isDigit(name.charAt(0))){
        return false;
    }
    
    for(int i = 0; i<name.length(); i++){
        
        if(!Character.isLetterOrDigit(name.charAt(i)) && name.charAt(i) != '_'){
            return false;
        }
    }
    return true;
}    
```

## 28| alphabeticShift
Given a string, your task is to replace each of its characters by the next one in the English alphabet.\
i.e. replace `a` with `b`, replace `b` with `c`, etc (`z` would be replaced by `a`).

#### Example
For `inputString = "crazy"`, the output should be `solution(inputString) = "dsbaz"`.

#### Solution
```java
String solution(String inputString) {
        
        String result = "";

        for(int i=0; i<inputString.length();i++){
         
            if(inputString.charAt(i) == 'z' || inputString.charAt(i) == 'Z' ){
                
                //CONVERT Z TO A
               result +=   'a';
               
            }
            else{
                
               //CHAR(TEXT) TO INT
               int int_temp = (int)inputString.charAt(i)+1 ;
               
               //INT TO CHAR(TEXT)
               char char_temp = (char)int_temp;
               
               result  += char_temp;
            }
    }
    return result;
}
```

## 29| chessBoardCellColor
Given two cells on the standard chess board, determine whether they have the same color or not.

#### Example
For `cell1 = "A1"` and `cell2 = "C3"`, the output should be `solution(cell1, cell2) = true`.
For `cell1 = "A1"` and `cell2 = "H3"`, the output should be `solution(cell1, cell2) = false`.

#### Solution
```java
boolean solution(String cell1, String cell2) {
    
    //CONVERT CHAR TO INT(ASCII)
    int c1_vertical  = (int)cell1.charAt(0) - 64 ; //A = 1
    int c1_horizon   = cell1.charAt(1);
    int c1_color     = -1;
    
    int c2_vertical  = (int)cell2.charAt(0) - 64 ;
    int c2_horizon   = cell2.charAt(1);
    int c2_color     = -1;
    
    if(c1_vertical % 2 == c1_horizon % 2){
        
        c1_color = 1; //LIGHT
        
    }
    else{
        c1_color = 0; //DARK
    }
    
    if(c2_vertical % 2 == c2_horizon % 2){
        
        c2_color = 1; //LIGHT
        
    }
    else{
        c2_color = 0; //DARK
    }
    
    //COMPARE
    
    if(c1_color == c2_color){
        return true;
    }
    else{
        return false;
    }  
}
```
