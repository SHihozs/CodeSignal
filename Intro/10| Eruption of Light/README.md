## 43| isBeautifulString
A string is said to be beautiful if each letter in the **string** appears at most as many times as **the previous letter in the alphabet within the string**. ie: `b` occurs no more times than `a`. `c` occurs no more times than `b`. etc.\
**Note that letter a has no previous letter.** Given a string, check whether it is *beautiful*.

#### Example
For `inputString = "bbbaacdafe"`, the output should be `solution(inputString) = true`.
This string contains 3 `a`s, 3 `b`s, `1` c, `1` d, `1` e, and `1` f (and 0 of every other letter), so since there aren't any letters that appear more frequently than the previous letter, this string qualifies as beautiful.

For `inputString = "aabbb"`, the output should be `solution(inputString) = false`.
Since there are more `b`s than `a`s, this string is not beautiful.

For `inputString = "bbc"`, the output should be `solution(inputString) = false`.
Although there are more bs than `c`s, this string is not beautiful because there are no `a`s, so therefore there are more `b`s than `a`s.

#### Solution
```java
boolean solution(String inputString) {
    
    TreeMap<Character,Integer> treemap = new TreeMap<>(); //SORT KEY

    //ADD ALL ALPHABET
    for(int i=0; i<26; i++){
        treemap.put((char)(i+97), 0); //97 = a
    }
    
    //COUNT ALPHABET
    for(int i=0; i<inputString.length(); i++){
        treemap.put(inputString.charAt(i),treemap.get(inputString.charAt(i))+1);
    }
    
    int prev_value = Integer.MAX_VALUE;
    
    for(Map.Entry<Character,Integer> m : treemap.entrySet()){
        if(m.getValue() > prev_value){
            return false;
        }else{
            //THE HIGHEST ALPHABET MUST HAVE THE HIGHEST VALUE.
            prev_value = m.getValue();
        }
    }
    return true;
}
```

## 44| Find Email Domain
An email address such as `"John.Smith@example.com"` is made up of a local part `("John.Smith")`, an `"@"` symbol, then a domain part `("example.com")`.\
The domain name part of an email address may only consist of letters, digits, hyphens and dots. The local part, however, also allows a lot of different special characters.\
Given a valid email address, find its domain part.

#### Example
For `address = "prettyandsimple@example.com"`, the output should be `solution(address) = "example.com"`.\
For `address = "fully-qualified-domain@codesignal.com"`, the output should be `solution(address) = "codesignal.com"`.

#### Solution
```java
String solution(String address) {
    
    //Given a valid email address, find its domain part
    String[] string_split  = address.split("@");
    
    return string_split[string_split.length-1];
}
```

## 45| buildPalindrome
Given a string, find the shortest possible string which can be achieved by adding characters to the end of initial string to make it a **palindrome**.

#### Example
For `st = "abcdc"`, the output should be `solution(st) = "abcdcba"`.

#### Solution
```java
String solution(String st) {

    /*
        abaa     --(rev)->   aaba
        i=0;     abaa   aaba
        i=1;     a|baa  aab|a
        i=2;     ab|aa  aa|ba
    */
    
    StringBuilder sBuilder = new StringBuilder();
    String sb = sBuilder.append(st).reverse().toString();
    String result = "";
    
    for(int i=0; i<st.length(); i++){
        if(sb.startsWith(st.substring(i))){
             //ab (i=0 - i=1) + aaba (rev)
             result = st.substring(0,i) + sb;
             break;
        } 
    } 
    return result;  
}
```

## 46| Elections Winners
Given an array of the numbers of votes given to each of the candidates so far, and an integer `k` equal to the number of voters who haven't cast their vote yet, find the number of candidates who still have a chance to win the election.\
The winner of the election must secure strictly more votes than any other candidate. If two or more candidates receive the same (maximum) number of votes, assume there is no winner at all.

#### Example
For `votes = [2, 3, 5, 2]` and `k = 3`, the output should be `solution(votes, k) = 2`.

+ The first candidate got `2` votes. Even if all of the remaining `3` candidates vote for him, he will still have only `5` votes, i.e. the same number as the third candidate, so there will be no winner.
+ The second candidate can win if all the remaining candidates vote for him `(3 + 3 = 6 > 5)`.
+ The third candidate can win even if none of the remaining candidates vote for him. For example, if each of the remaining voters cast their votes for each of his opponents, he will still be the winner (the `votes` array will thus be `[3, 4, 5, 3]`).
+ The last candidate can't win no matter what (for the same reason as the first candidate).
Thus, only `2` candidates can win (the second and the third), which is the answer.

#### Solution
```java
int solution(int[] votes, int k) {
    
    //FIND MAX VOTES IN ARRAY
    int max = Integer.MIN_VALUE;
    for(int i=0; i<votes.length; i++){
        if(votes[i] > max){
            max = votes[i];
        }
    }
    
    //FIND BEST CASE
    int count = 0;
    int value = 0;
    
    for(int i=0 ; i<votes.length ; i++){
        if((votes[i]+k) > max){
            count += 1;
        }
        else{
            if(votes[i] == max){
                value += 1;
            }
        }
    }
    
    if(value > 1){
        return 0;
    }
    else if (value == 1){
        count = value;
    }
    
    return count;
}
```

## 47| Is MAC48 Address?
A media access control address (MAC address) is a unique identifier assigned to network interfaces for communications on the physical network segment.\
The standard (IEEE 802) format for printing MAC-48 addresses in human-friendly form is six groups of two hexadecimal digits (`0` to `9` or `A` to `F`), separated by hyphens (e.g. `01-23-45-67-89-AB`).\
Your task is to check by given string `inputString` whether it corresponds to MAC-48 address or not.

#### Example
For `inputString = "00-1B-63-84-45-E6"`, the output should be `solution(inputString) = true`.\
For `inputString = "Z1-1B-63-84-45-E6"`, the output should be `solution(inputString) = false`.\
For `inputString = "not a MAC-48 address"`, the output should be `solution(inputString) = false`.

#### Solution
```java
boolean solution(String inputString) {

    String[] s_split = inputString.split("-");
    
    if(inputString.charAt(0) == '-' || inputString.charAt(inputString.length()-1) == '-'){return false;}
    
    for(int i=0; i<s_split.length; i++){
        if(s_split[i].length() != 2){return false;}
       
       
        if((s_split[i].charAt(0) < '0' || s_split[i].charAt(0) > '9')&&
           (s_split[i].charAt(0) < 'A' || s_split[i].charAt(0) > 'F')){return false;}
        if((s_split[i].charAt(1) < '0' || s_split[i].charAt(1) > '9')&& 
           (s_split[i].charAt(1) < 'A' || s_split[i].charAt(1) > 'F')){return false;}    
            
    }
    return true; 
}
```

