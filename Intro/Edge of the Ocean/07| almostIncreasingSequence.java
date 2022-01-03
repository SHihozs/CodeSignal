boolean solution(int[] sequence) {
    
 int removed = 0;
 int max = Integer.MIN_VALUE;
 int prev_max = max;
 
 for(int i=0; i<sequence.length; i++){
    
    //BEST CASE
    if(sequence[i] > max){
        prev_max = max;
        max      = sequence[i];
    }
    
    //REMOVE_ONE
    else if(sequence[i] > prev_max){
        removed++;
        max = sequence[i];
    }
    
    //CHECK_TWO
    else{
        removed++;
    }
    
    //IF REMOVE MORE THAN ONE TIME
    if(removed > 1){
        return false;
    }
 }
 return true; //ex. 1 3 2 4
    
}


/*
    1 3 2 1

i=0
1>-100000
pre = -100000
max = 1

i=1
3>1(max)
pre = 1 // because 1 greater than 3 only
max = 3

i=2
2>1(pre)
remove = 1
max    = 2

i=3
remove = 2

thus false
    
    
    */
