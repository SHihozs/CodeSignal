## 52| longestWord
Define a **word** as a sequence of consecutive English letters. Find the longest **word** from the given string.

#### Example
For `text = "Ready, steady, go!"`, the output should be `solution(text) = "steady"`.

#### Solution
```java
String solution(String text) {
    
    String longest = "";
    String result  =  "";
    int count = 0;
    int max = Integer.MIN_VALUE;
    
    for(int i=0; i<text.length(); i++){
        if((text.charAt(i) >= 'a' && text.charAt(i) <= 'z') || (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z')){
            count   += 1;
            longest += text.charAt(i);
        }
        else{
            //CHECK LONGEST
            if(count > max){
                max    = count;
                result = longest;
            }
        count   = 0;
        longest = "";
        }
    } 
    
        //text: "ABCd"
        //text: "aaa bb cccc"
        
        if(result.length() < longest.length()){
           result = longest;
        }
    return result;
}
```

## 53| Valid Time
Check if the given string is a correct time representation of the 24-hour clock.

#### Example
For `time = "13:58"`, the output should be `solution(time) = true`.\
For `time = "25:51"`, the output should be `solution(time) = false`.\
For `time = "02:76"`, the output should be `solution(time) = false`.

#### Solution
```java
boolean solution(String time) {
    
    String[] split = time.split(":");
    
    if(Integer.parseInt(split[0]) > 23 || Integer.parseInt(split[1]) > 59 ){
        return false;
    }
    return true;
}
```

## 54| sumUpNumbers
CodeMaster has just returned from shopping. He scanned the check of the items he bought and gave the resulting string to Ratiorg to figure out the total number of purchased items. Since Ratiorg is a bot he is definitely going to automate it, so he needs a program that sums up all the numbers which appear in the given input.\
Help Ratiorg by writing a function that returns the sum of numbers that appear in the given `inputString`.

#### Example
For `inputString = "2 apples, 12 oranges"`, the output should be `solution(inputString) = 14`.

#### Solution
```java
int solution(String inputString) {
    
    String add = "";
    int sum    = 0;
    
    for(int i=0; i<inputString.length(); i++){
        if(Character.isDigit(inputString.charAt(i))){
            add += inputString.charAt(i);
        }
        else{
            //ALPHABET
            if(add != ""){
               sum += Integer.parseInt(add);
               add  = "";
            }       
        }
    }
    
    //inputString: "123450"
    if(add != ""){
       sum += Integer.parseInt(add);
    }
    
    return sum;
}
```

## 55| Different Squares
Given a rectangular matrix containing only digits, calculate the number of different `2 × 2` squares in it.

#### Example
For matrix =\
[[1, 2, 1],\
 [2, 2, 2],\
 [2, 2, 2],\
 [1, 2, 3],\
 [2, 2, 1]]
              
the output should be `solution(matrix) = 6`.\
Here are all `6` different `2 × 2` squares:

+ 1 2\
2 2

+ 2 1\
2 2

+ 2 2\
2 2

+ 2 2\
1 2

+ 2 2\
2 3

+ 2 3\
2 1

#### Solution
```java
int solution(int[][] matrix) {
    
    HashSet<String> hashSet = new HashSet<>();
    String temp = "";
    
     for(int i=0; i<matrix.length-1; i++){
         for(int j=0; j<matrix[0].length-1; j++){
             
             temp = matrix[i][j] + "-" + matrix[i][j+1] + "-" + matrix[i+1][j] + "-" + matrix[i+1][j+1];                 
             hashSet.add(temp);
             
         }
     }
     return hashSet.size();
}
```

## 56| digitsProduct
Given an integer `product`, find the **smallest positive** (i.e. greater than `0`) integer the `product` of whose digits is equal to product.\
If there is no such integer, return `-1` instead.

#### Example
For `product = 12`, the output should be `solution(product) = 26`.\
For `product = 19`, the output should be `solution(product) = -1`.


#### Solution
```java
int solution(int product) {
    
    Stack<Integer> stack = new Stack<>();
    
    if(product == 0){return 10;}
    if(product < 10){return product;} //one digit
    
    for(int i=9; i>1; i--){
        if(product % i == 0){
           product /= i;
           stack.push(i);
           i=10; //protect i--
        }
        if(product < 10){
           stack.push(product);
           break;
        }
    }
    
    //case 33 = 1*11 --> (11==prime)
    if(product > 10){
        return -1;
    }
    
    String result = "";
    while(!stack.isEmpty()){
        result += stack.pop();
    }
    
    //PRIME
    if(result == ""){
        return -1;
    }
    
    return Integer.parseInt(result);
}
```

## 57| File Naming
You are given an array of desired filenames in the order of their creation. Since two files cannot have equal names, the one which comes later will have an addition to its name in a form of `(k)`, where `k` is the smallest positive integer such that the obtained name is not used yet.\
Return an array of names that will be given to the files.

#### Example
For `names = ["doc", "doc", "image", "doc(1)", "doc"]`,\
the output should be `solution(names) = ["doc", "doc(1)", "image", "doc(1)(1)", "doc(2)"]`.

#### Solution
```java
String[] solution(String[] names) {

   HashSet<String> hashSet = new HashSet<>();
   String[] result = new String[names.length];
   
   for(int i=0; i<names.length; i++){
       String name = names[i];
       if(!hashSet.contains(name)){
           hashSet.add((name));
           result[i] = name;
       }
       else{
           String nameDuplicate = name;
           int k=0;
           while(hashSet.contains(nameDuplicate)){
               k += 1;
               nameDuplicate = name + "(" + k + ")";
           }
           
           hashSet.add(nameDuplicate);
           result[i] = nameDuplicate;
       }
   }
   return result;
}
```

## 58| messageFromBinaryCode
You are taking part in an Escape Room challenge designed specifically for programmers. In your efforts to find a clue, you've found a binary code written on the wall behind a vase, and realized that it must be an encrypted message. After some thought, your first guess is that each consecutive `8` bits of the code stand for the character with the corresponding extended **ASCII code**.\
Assuming that your hunch is correct, decode the message.

#### Example
For `code = "010010000110010101101100011011000110111100100001"`, the output should be `solution(code) = "Hello!"`.

The first `8` characters of the code are `01001000`, which is `72` in the binary numeral system. `72` stands for `H` in the ASCII-table, so the first letter is `H`.
Other letters can be obtained in the same manner.

#### Solution
```java
String solution(String code) {
    
    List<String> list = new ArrayList<String>();
    int index = 0;
    while (index < code.length()) {
        list.add(code.substring(index, Math.min(index + 8,code.length())));
        index += 8;
    }
    
    int charCode = 0;
    String result   = "";
    for(String l : list){
        charCode = Integer.parseInt(l, 2); //binary to decimal
        result  += (char)charCode+"";      //decimal to ASCII
    }
    return result;
}
```

## 59| spiralNumbers
Construct a square matrix with a size `N × N` containing integers from `1` to `N * N` in a spiral order, starting from top-left and in clockwise direction.

#### Example
For `n = 3`, the output should be solution(n) =\
[[1, 2, 3],\
 [8, 9, 4],\
 [7, 6, 5]]

#### Solution
```java
int[][] solution(int n) {
    
    int[][] result = new int [n][n];
    
    //INITIAL VALUE
    int value  = 1;
    int minCol = 0;
    int minRow = 0;
    int maxCol = n-1;
    int maxRow = n-1;
    
    //COUNT NUMBER
    while (value <= n*n){
        for (int i = minCol; i <= maxCol; i++){
            result[minRow][i] = value;  //[0][0] > [0][1] > [0][2]
            value++;
        }
 
        for (int i = minRow+1; i <= maxRow; i++) { 
            result[i][maxCol] = value;  //[1][2] > [2][2] 
            value++; 
        } 
             
        for (int i = maxCol-1; i >= minCol; i--){
            result[maxRow][i] = value;  //[2][1] > [2][0] 
            value++;
        }
             
        for (int i = maxRow-1; i >= minRow+1; i--){
            result[i][minCol] = value;  //[1][0] 
            value++;
        }
             
        minCol++;
        minRow++;
        maxCol--;
        maxRow--;
    }
    return result;   
}
```

## 60| Sudoku
Sudoku is a number-placement puzzle. The objective is to fill a `9 × 9` grid with digits so that each column, each row, and each of the nine `3 × 3` sub-grids that compose the grid contains all of the digits from `1` to `9`.\
This algorithm should check if the given grid of numbers represents a correct solution to Sudoku.

#### Example
For grid =\
       [[1, 3, 2, 5, 4, 6, 9, 8, 7],\
        [4, 6, 5, 8, 7, 9, 3, 2, 1],\
        [7, 9, 8, 2, 1, 3, 6, 5, 4],\
        [9, 2, 1, 4, 3, 5, 8, 7, 6],\
        [3, 5, 4, 7, 6, 8, 2, 1, 9],\
        [6, 8, 7, 1, 9, 2, 5, 4, 3],\
        [5, 7, 6, 9, 8, 1, 4, 3, 2],\
        [2, 4, 3, 6, 5, 7, 1, 9, 8],\
        [8, 1, 9, 3, 2, 4, 7, 6, 5]]
        
the output should be `solution(grid) = true`.

For grid =\
       [[1, 3, 2, 5, 4, 6, 9, 2, 7],\
        [4, 6, 5, 8, 7, 9, 3, 8, 1],\
        [7, 9, 8, 2, 1, 3, 6, 5, 4],\
        [9, 2, 1, 4, 3, 5, 8, 7, 6],\
        [3, 5, 4, 7, 6, 8, 2, 1, 9],\
        [6, 8, 7, 1, 9, 2, 5, 4, 3],\
        [5, 7, 6, 9, 8, 1, 4, 3, 2],\
        [2, 4, 3, 6, 5, 7, 1, 9, 8],\
        [8, 1, 9, 3, 2, 4, 7, 6, 5]]
        
the output should be `solution(grid) = false`. each of the nine `3 × 3` sub-grids should contain all of the digits from `1` to `9`.

#### Solution
```java
boolean solution(int[][] grid) {
    
    Queue<Integer> queueRow = new LinkedList<>();
    Queue<Integer> queueCol = new LinkedList<>();
    
    //LOOP ROW & COL
    for(int i=0; i<grid[0].length; i++){//row
        for(int j=0; j<grid[0].length; j++){//col
        
           int valueRow = grid[i][j];
           int valueCol = grid[j][i];
            
            //ROW
            if(!queueRow.contains(valueRow)){
                queueRow.add(valueRow);
            }
            else{
                queueRow.clear();
                return false;
            }
            
            //COL
            if(!queueCol.contains(valueCol)){
                queueCol.add(valueCol);
            }
            else{
                queueCol.clear();
                return false;
            }  
        }
        queueRow.clear();
        queueCol.clear();
    }
    
    //SUB-MATRIX
    Queue<Integer> queue = new LinkedList<>();
    int col = 0;
    int row = 0;

    //LOOP SUB-MATRIX
    for(int i=0; i<9; i++){
      for(int r=row; r<row+3; r++){
        for(int c=col; c<col+3; c++){   
            
            int value = grid[r][c];
            
            if(!queue.contains(value)){
                queue.add(value);
            }
            else{
                queue.clear();
                return false;
            } 
        }  
    }
    queue.clear();
    
    //LOOP SUB-MATRIX [BIG] 
    if(col ==  6){
       row += 3;
       col  = 0;
    }
    else{
       col += 3; 
    }
    
  }
  return true;
}
```
