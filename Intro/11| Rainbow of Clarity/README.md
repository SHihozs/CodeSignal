## 48| isDigit
Determine if the given character is a digit or not.

#### Example
For `symbol = '0'`, the output should be `solution(symbol) = true`\
For `symbol = '-'`, the output should be `solution(symbol) = false`.

#### Solution
```java
boolean solution(char symbol) {
    
    if(symbol >= '0' && symbol <= '9'){
        return true;
    }
    return false;
}
```

## 49| lineEncoding
Given a string, return its encoding defined as follows:
+ First, the string is divided into the least possible number of disjoint substrings consisting of identical characters for example, `"aabbbc"` is divided into `["aa", "bbb", "c"]`
+ Next, each substring with length greater than one is replaced with a concatenation of its length and the repeating character for example, **substring** `"bbb"` is replaced by `"3b"`
+ Finally, all the new strings are concatenated together in the same order and a new string is returned.

#### Example
For `s = "aabbbc"`, the output should be `solution(s) = "2a3bc"`.

#### Solution
```java
String solution(String s) {
    
    Queue<Character> queue = new LinkedList<>();
    String result = "";
    int count = 0;
    
    for(int i=0; i<s.length(); i++){
        if(!queue.isEmpty() && s.charAt(i) != queue.peek()){
            if(count == 1){
                result += queue.poll();
                queue.clear();
                queue.add(s.charAt(i));
                count = 1;
            }
            else{
                result += Integer.toString(count) + queue.poll(); 
                queue.clear();
                queue.add(s.charAt(i));
                count = 1;
            }    
        }
        else{
            queue.add(s.charAt(i));
            count  += 1;
        }
    }
    
    if(!queue.isEmpty()){
        if(count != 1){
            //s: "ccccccccccccccc"
            result += Integer.toString(count) + queue.poll(); 
        }
        else{
            //s: "aabbbc" --> get output --> "2a3b1c" (last index with count = 1)
            result += queue.poll();
            queue.clear();
        }
        
    }
    return result;
}
```

## 50| chessKnight
Given a position of a knight on the standard chessboard, find the number of different moves the knight can perform.\
The knight can move to a square that is two squares horizontally and one square vertically, or two squares vertically and one square horizontally away from it.\
The complete move therefore looks like the letter L. Check out the image below to see all valid moves for a knight piece that is placed on one of the central squares.

#### Example
For `cell = "a1"`, the output should be `solution(cell) = 2`.\
For `cell = "c2"`, the output should be `solution(cell) = 6`.

#### Solution
```java
int solution(String cell) 
{
    int row = (int) cell.charAt(0) - 96; //a=1
    int col = (int) cell.charAt(1) - 48; //1=1

    int move = 0;

    if(row + 1 <= 8 && col + 2 <= 8)
    {
        move++;
    }
    if(row + 2 <= 8 && col + 1 <= 8)
    {
        move++;
    }
    if(row - 1 >= 1 && col + 2 <= 8)
    {
        move++;
    }
    if(row - 2 >= 1 && col + 1 <= 8)
    {
        move++;
    }
    if(row - 1 >= 1 && col - 2 >= 1)
    {
        move++;
    }
    if(row - 2 >= 1 && col - 1 >= 1)
    {
        move++;
    }
    if(row + 1 <= 8 && col - 2 >= 1)
    {
        move++;
    }
    if(row + 2 <= 8 && col - 1 >= 1)
    {
        move++;
    }

    return move;
}
```

## 51| deleteDigit
Given some integer, find the maximal number you can obtain by deleting exactly one digit of the given number.

#### Example
For `n = 152`, the output should be `solution(n) = 52`.\
For `n = 1001`, the output should be `solution(n) = 101`.

#### Solution
```java
int solution(int n) {

    /*
        1234 -> 234, 134, 124, 123 --> MAX IS --> 234
    */

    //CONVERT INT TO STRING
    String s = Integer.toString(n);
    int max  = Integer.MIN_VALUE;
    String result = "";
    
    for(int i=0; i<s.length(); i++){
        for(int j=0; j<s.length(); j++){
            if(i!=j){
                result += s.charAt(j);
            }
        }
        
        if(Integer.parseInt(result) > max){
            max = Integer.parseInt(result);
        }
        result = "";
    }
    return max;
}
```
