## 01| containsDuplicates
Given an array of integers, write a function that determines whether the array contains any duplicates.\
Your function should return `true` if any element appears at least twice in the array, and it should return `false` if every element is distinct.

#### Example
For `a = [1, 2, 3, 1]`, the output should be `solution(a) = true`.
There are two 1s in the given array.

For `a = [3, 1]`, the output should be `solution(a) = false`.
The given array contains no duplicates.

#### Solution
```java
boolean solution(int[] a) {
    Map<Integer,Boolean> map = new HashMap<Integer,Boolean>();
    
    for(int i=0; i<a.length; i++){
        if(!map.containsKey(a[i])){
            map.put(a[i], false);
        }
        else{
            map.put(a[i], true);
        }    
    }
    
    for(Map.Entry<Integer,Boolean> m : map.entrySet()){
        if(m.getValue() == true){
            return true;
        }
    }
    return false;
}
```

## 02| sumOfTwo
You have two integer arrays, `a` and `b`, and an integer target value `v`. Determine whether there is a pair of numbers, where one number is taken from `a` and the other from `b`, that can be added together to get a sum of `v`.\
Return `true` if such a pair exists, otherwise return `false`.

#### Example
For `a = [1, 2, 3]`, `b = [10, 20, 30, 40]`, and `v = 42`, the output should be `solution(a, b, v) = true`.

#### Solution
```java
boolean solution(int[] a, int[] b, int v) {
    
  HashSet hash = new HashSet<>();
  
  //PUT A IN HASHMAP
  for(int i=0; i<a.length; i++){
      hash.add(a[i]);
  }
  
  //CHECK a = v-b
  for(int i=0; i<b.length; i++){
      //PAIR EXIST
      if(hash.contains(v-b[i])) return true;
  }
  
  //NO PAIR 
  return false;
}
```
