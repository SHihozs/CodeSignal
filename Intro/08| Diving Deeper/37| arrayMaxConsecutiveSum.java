int solution(int[] inputArray, int k) {
    
    //if the value 'k' is higher then the loop for is lower
    
    int max =Integer.MIN_VALUE;
    
    for(int i=0; i<inputArray.length-(k-1); i++){
        
        int sum = 0;
        
        for(int j=i+1; j<(k+i); j++){
            
            sum += inputArray[j];
            
        }
        
        sum += inputArray[i];
        
        //CHECK MAX
        if(sum > max){
            max = sum;
        } 
    }
    return max;
}
