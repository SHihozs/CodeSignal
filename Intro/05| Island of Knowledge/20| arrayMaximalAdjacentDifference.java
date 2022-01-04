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
