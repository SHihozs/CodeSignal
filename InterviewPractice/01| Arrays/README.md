## 01| firstDuplicate
Given an array `a` that contains only numbers in the range from `1` to `a.length`, find the first duplicate **number** for which the second occurrence has the minimal index.In other words. if there are more than 1 duplicated numbers.\
Return the **number** for which the second occurrence has a smaller index than the second occurrence of the other number does. If there are no such elements, return `-1`.

#### Example
For `a = [2, 1, 3, 5, 3, 2]`, the output should be `solution(a) = 3`. There are `2` duplicates: numbers `2` and `3`. The second occurrence of `3` has a smaller index than the second occurrence of `2` does, so the answer is `3`.

For `a = [2, 2]`, the output should be `solution(a) = 2`.

For `a = [2, 4, 3, 5, 1]`, the output should be `solution(a) = -1`.

#### Solution
```java
int solution(int[] a) {

int [] array = new int [a.length]; //local

    for(int i=0; i<a.length; i++){
        array[i] = -1;
        
        for(int j=i+1; j<a.length; j++){
            
            if(a[i] == a[j]){ 
               array[i] = j;
               break; //go to loop next i
            }  
        } 
    }
    
    int min   = Integer.MAX_VALUE;
    int index = -1;
    
    for(int i=0; i<array.length; i++){
        if(array[i] < min && array[i] != -1){
            min   = array[i];
            index = i;
        }
    } 
    
    if(index == -1) return index;
    else return a[index];
}
```

## 02| firstNotRepeatingCharacter
Given a string `s` consisting of small English letters, find and return the first instance of a non-repeating character in it. If there is no such character, return `'_'`.

#### Example
For `s = "abacabad"`, the output should be `solution(s) = 'c'`.\
There are `2` non-repeating characters in the string: `'c'` and `'d'`. Return `c` since it appears in the string first.

For `s = "abacabaabacaba"`, the output should be `solution(s) = '_'`.\
There are no characters in this string that do not repeat.

#### Solution
```java
char solution(String s) {
int [] array = new int [s.length()]; //local    

    for(int i=0; i<s.length(); i++){
        array[i] = -1;
            for(int j=0; j<s.length();j++){
                if(i!=j){   //check if i have same position j
                    if(s.charAt(i) == s.charAt(j)){
                   array[i] = j;
                   break;  //go to loop i 
                 }
                }
                
            }
    }
    
    int index = -1;
    for(int i=0; i<array.length; i++){
        if(array[i] == -1){
            index = i;
            break;
        }
    }
    
    if(index != -1) return s.charAt(index);
    else return '_';
}
```

## 03| rotateImage
*Note: Try to solve this task in-place (with O(1) additional memory), since this is what you'll be asked to do during an interview.*\
You are given an n x n 2D matrix that represents an image. Rotate the image by 90 degrees (clockwise).

#### Example
For a =\
[[1, 2, 3],\
 [4, 5, 6],\
 [7, 8, 9]]

the output should be solution(a) =\
[[7, 4, 1],\
 [8, 5, 2],\
 [9, 6, 3]]

#### Solution
```java
int[][] solution(int[][] a) {

int[][] b = new int [a.length][a[0].length];

/*
a = [[1, 2, 3],
     [4, 5, 6],
     [7, 8, 9]]
    
    i = 0
    k = a[i].length-1 so k=2 --> [7,8,9]
*/

    for(int i=0; i<a.length; i++){  
        int k = a[i].length-1; 
            for(int j=0; j<a[i].length; k--,j++){    
                b[i][j] = a[k][i];
        }
    } return b; 
}
```
