## 19| areEquallyStrong
Call two arms **equally strong** if the heaviest weights they each are able to lift are equal.\
Call two people **equally strong** if their strongest arms are equally strong (the strongest arm can be both the right and the left), and so are their weakest arms.\
Given your and your friend's arms' lifting capabilities find out if you two are equally strong.

#### Example
For `yourLeft = 10`, `yourRight = 15`, `friendsLeft = 15`, and `friendsRight = 10`, the output should be `solution(yourLeft, yourRight, friendsLeft, friendsRight) = true`.

For `yourLeft = 15`, `yourRight = 10`, `friendsLeft = 15`, and `friendsRight = 10`, the output should be `solution(yourLeft, yourRight, friendsLeft, friendsRight) = true`.

For `yourLeft = 15`, `yourRight = 10`, `friendsLeft = 15`, and `friendsRight =  9`, the output should be `solution(yourLeft, yourRight, friendsLeft, friendsRight) = false`.

#### Solution
```java
boolean solution(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {
    
    //MY
    int my_max = 0;
    int my_min = 0;
    
    if(yourRight > yourLeft){
        my_max = yourRight;
        my_min = yourLeft;
    }
    else{
        my_max = yourLeft;
        my_min = yourRight;
    }
    
    //FRIEND
    int friend_max = 0;
    int friend_min = 0;
    
    if(friendsRight > friendsLeft){
        friend_max = friendsRight;
        friend_min = friendsLeft;
    }
    else{
        friend_max = friendsLeft;
        friend_min = friendsRight;
    }
    
    
    if(my_max != friend_max || my_min != friend_min){
        return false;
    }
    else{
        return true;
    }
}
```

## 20| arrayMaximalAdjacentDifference
Given an array of integers, find the maximal absolute difference between any two of its adjacent elements.

#### Example
For `inputArray = [2, 4, 1, 0]`, the output should be `solution(inputArray) = 3`.

#### Solution
```java
int solution(int[] inputArray) {
        
        int max = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int i=0; i<inputArray.length-1; i++){
            if(inputArray[i] < inputArray[i+1]){
                max = Math.abs(inputArray[i+1] - inputArray[i]);
            }
            else if(inputArray[i] > inputArray[i+1]){
                max = Math.abs(inputArray[i] - inputArray[i+1]);
            }
            
            if(max > sum){
                sum = max;
                max = Integer.MIN_VALUE;
            }
        }
        
    return sum;
}
```

## 21| isIPv4Address
An IP address is a numerical label assigned to each device (e.g., computer, printer) participating in a computer network that uses the Internet Protocol for communication. There are two versions of the Internet protocol, and thus two versions of addresses. One of them is the **IPv4 address**.\
Given a string, find out if it satisfies the IPv4 address naming rules.

#### Example
For `inputString = "172.16.254.1"`, the output should be `solution(inputString) = true`.\
For `inputString = "172.316.254.1"`, the output should be `solution(inputString) = false`. `316` is not in range `[0, 255]`.\
For `inputString = ".254.255.0"`, the output should be `solution(inputString) = false`. There is no first number.

#### Solution
```java
boolean solution(String inputString) {
    
    //REGEX
    String buf[] = inputString.split("\\.");
    int convert  = 0;
    
    for(int i=0; i<buf.length; i++){
        
        try{
            //PARSEINT USE WHEN CONVERT STRING TO INT
            convert = Integer.parseInt(buf[i]);
        }
        catch(NumberFormatException e){
            return false;
        }
        
        //CHARCK CONDITION
        //1. SIZE
        if(buf.length > 4 || buf.length < 4){
            return false;
        }
        
        //2. ADDRESS
        if(convert > 255 || convert < 0){
            return false;
        }
        
        //3. FIRST ZERO
        if(buf[i].length() > 1 && buf[i].charAt(0) == '0'){
            return false;
        }       
    }
    return true;
}
```

## 22| avoidObstacles
You are given an array of integers representing coordinates of obstacles situated on a straight line.\
Assume that you are jumping from the point with coordinate `0` to the right. You are allowed only to make jumps of the same length represented by some integer.\
Find the minimal length of the jump enough to avoid all the obstacles.

#### Example
For `inputArray = [5, 3, 6, 7, 9]`, the output should be `solution(inputArray) = 4`.

#### Solution
```java
int solution(int[] inputArray) {
    
    //FIND MAX OF ARRAY
    int max = Integer.MIN_VALUE;
    
    for(int i=0; i<inputArray.length; i++){
        if(inputArray[i] > max){
            max = inputArray[i];
        }
    }
    
    int jmp = 1;
    
    for(int i = 0; i <= max ; i+=jmp){
        
        for(int j = 0; j<inputArray.length; j++){
            
             //INPUTARRAY[j] == i MEANS JUMP = .... IS NOT OK
             if(inputArray[j] == i){
                 
                 //JUMP FAR
                 jmp += 1;
                 //SET INITIAL 
                 i=0;
             
             }
             
             //INPUTARRAY[j] != i MEANS JUMP = .... IS OK
        }
    }
        
    return jmp;
}
```

## 23| Box Blur
Last night you partied a little too hard. Now there's a black and white photo of you that's about to go viral! You can't let this ruin your reputation, so you want to apply the **box blur algorithm** to the photo to hide its content.\
The pixels in the input image are represented as integers. The algorithm distorts the input image in the following way: Every pixel `x` in the output image has a value equal to the average value of the pixel values from the `3 × 3` square that has its center at `x`, including `x` itself. All the pixels on the border of `x` are then removed.\
Return the blurred image as an integer, with the fractions rounded down.

#### Example
For `image = [[1, 1, 1], 
             [1, 7, 1], 
             [1, 1, 1]]`
the output should be `solution(image) = [[1]]`.\
To get the value of the middle pixel in the input `3 × 3` square: `(1 + 1 + 1 + 1 + 7 + 1 + 1 + 1 + 1) = 15 / 9 = 1.66666 = 1`.\
The border pixels are cropped from the final result.

For `image = [[7, 4, 0, 1], 
             [5, 6, 2, 2], 
             [6, 10, 7, 8], 
             [1, 4, 2, 0]]`
the output should be `solution(image) = [[5, 4], 
                                        [4, 4]]`\
There are four `3 × 3` squares in the input image, so there should be four integers in the blurred output.\
To get the first value: `(7 + 4 + 0 + 5 + 6 + 2 + 6 + 10 + 7) = 47 / 9 = 5.2222 = 5`.\
The other three integers are obtained the same way, then the surrounding integers are cropped from the final result.

#### Solution
```java
int[][] solution(int[][] image) {
    
    //MAKE A ANSWER ARRAY (ROW)
    int[][] array  = new int [image.length-2][];
    
    //MAKE A ANSWER ARRAY (COL)
    for(int i=0; i<array.length; i++){
        array[i] = new int [image[0].length-2];
    }
    
    //CHECK 3x3
    /*
        1. use i for iden index of answer array (row) 
        2. use j for iden index of answer array (col) 
    */
    
    for(int r=0; r+3 <= image.length; r++){
        for(int c=0; c+3 <= image[0].length;c++){
            
            int row = r;
            int col = c;
            int sum = 0;
            
            while(col < c+3 && row < r+3){
                sum += image[row][col];
                //CHANGE COL
                col++;
                
                if(col >= c+3 && row < r+3){
                    //CHANGE ROW
                    row++;
                    col = c;
                }
            }
            
            sum = sum/9;
            array[r][c] = sum;
        }
    }
    
    return array;  
}
```

## 24| Minesweeper
In the popular **Minesweeper** game you have a board with some mines and those cells that don't contain a mine have a number in it that indicates the total number of mines in the neighboring cells.

Starting off with some arrangement of mines we want to create a **Minesweeper** game setup.

#### Example
For
`matrix = [[true, false, false],
          [false, true, false],
          [false, false, false]]`

the output should be `solution(matrix) = [[1, 2, 1],
                                         [2, 1, 1],
                                         [1, 1, 1]]`

#### Solution
```java
int[][] solution(boolean[][] matrix) {
    
    int [][] answer = new int [matrix.length][matrix[0].length];
    
    for(int i=0; i<matrix.length; i++){
        for(int j=0; j<matrix[0].length; j++){
            
            int sum = 0;
            
            //CORNOR
            if(i == 0 && j == 0){//ABOVE-LEFT
                if(matrix[i][j+1] == true){
                    sum += 1;
                }
                if(matrix[i+1][j] == true){
                    sum += 1;
                }
                if(matrix[i+1][j+1] == true){
                    sum += 1;
                }  
            }
                 
            else if(i == 0 && j == matrix[i].length-1){//ABOVE-RIGHT
                if(matrix[i][j-1] == true){
                    sum += 1;
                }
                if(matrix[i+1][j] == true){
                    sum += 1;
                }
                if(matrix[i+1][j-1] == true){
                    sum += 1;
                }
                
            }
            
            else if(i == matrix.length-1 && j == 0){//UNDER-LEFT
                if(matrix[i][j+1] == true){
                    sum += 1;
                }
                if(matrix[i-1][j] == true){
                    sum += 1;
                }
                if(matrix[i-1][j+1] == true){
                    sum += 1;
                }
            }
            
            else if(i == matrix.length-1 && j == matrix[i].length-1){//UNDER-RIGHT
                if(matrix[i][j-1] == true){
                    sum += 1;
                }
                if(matrix[i-1][j-1] == true){
                    sum += 1;
                }
                if(matrix[i-1][j] == true){
                    sum += 1;
                }
            }
            
            //BORDER
            
            else if(j == 0){//LEFT
                
                if(matrix[i-1][j] == true){
                    sum += 1;
                }
                if(matrix[i-1][j+1] == true){
                    sum += 1;
                }
                if(matrix[i+1][j] == true){
                    sum += 1;
                }
                if(matrix[i+1][j+1] == true){
                    sum += 1;
                }
                if(matrix[i][j+1] == true){
                    sum += 1;
                }
            }
            
            else if(j == matrix[i].length-1){//RIGHT
                if(matrix[i-1][j] == true){
                    sum += 1;
                }
                if(matrix[i-1][j-1] == true){
                    sum += 1;
                }
                if(matrix[i+1][j] == true){
                    sum += 1;
                }
                if(matrix[i+1][j-1] == true){
                    sum += 1;
                }
                if(matrix[i][j-1] == true){
                    sum += 1;
                }    
            }
            
            else if(i == 0){//ABOVE
                if(matrix[i][j-1] == true){
                    sum += 1;
                }
                if(matrix[i][j+1] == true){
                    sum += 1;
                }
                if(matrix[i+1][j-1] == true){
                    sum += 1;
                }
                if(matrix[i+1][j] == true){
                    sum += 1;
                }
                if(matrix[i+1][j+1] == true){
                    sum += 1;
                }
            }
            
            else if(i == matrix.length-1){//UNDER
                if(matrix[i][j-1] == true){
                    sum += 1;
                }
                 if(matrix[i][j+1] == true){
                    sum += 1;
                }
                 if(matrix[i-1][j-1] == true){
                    sum += 1;
                }
                if(matrix[i-1][j] == true){
                    sum += 1;
                }
                if(matrix[i-1][j+1] == true){
                    sum += 1;
                }
            }
            
            //MIDDLE
            else{
                if(matrix[i-1][j-1] == true){ //ABOVE-LEFT
                    sum += 1;
                }
                if(matrix[i-1][j] == true){ //ABOVE-MID
                    sum += 1;
                }
                if(matrix[i-1][j+1] == true){ //ABOVE-RIGHT
                    sum += 1;
                }
                if(matrix[i][j-1] == true){ //MID-LEFT
                    sum += 1;
                }
                if(matrix[i][j+1] == true){ //MID-RIGHT
                    sum += 1;
                }
                if(matrix[i+1][j-1] == true){ //UNDER-LEFT
                    sum += 1;
                }
                if(matrix[i+1][j] == true){ //UNDER-MID
                    sum += 1;
                }
                if(matrix[i+1][j+1] == true){ //UNDER-RIGHT
                    sum += 1;
                }
                
            }
            
            answer[i][j] = sum;  
        } 
            
    }
    return answer;
}
```
