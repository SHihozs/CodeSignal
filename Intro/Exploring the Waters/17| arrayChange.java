int solution(int[] inputArray) {
    
    /*
        [1,1,1] --> minimum should --> [1,1+1,1+1+1] --> count (+1) = 3
    */
    
    int count = 0;
    for(int i=0; i<inputArray.length-1; i++){
        
        while(inputArray[i+1] <= inputArray[i]){
            count += 1;
            inputArray[i+1] += 1;
        }
    }
    return count;
}

