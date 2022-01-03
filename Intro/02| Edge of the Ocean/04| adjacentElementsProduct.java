int solution(int[] inputArray) {
    
    int max = Integer.MIN_VALUE;
    
    for(int i=0; i<inputArray.length-1;i++){       //protect index out of bound
        if(inputArray[i] * inputArray[i+1]>max){
            max = inputArray[i]*inputArray[i+1];       
        }       
    }
    return max;
}
