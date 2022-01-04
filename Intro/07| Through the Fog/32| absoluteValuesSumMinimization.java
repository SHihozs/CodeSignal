int solution(int[] a) {
    
    int min    = Integer.MAX_VALUE;
    int result = 0;
    
    for(int i=0; i<a.length; i++){
  
        int sum = 0;
        
        for(int j=0; j<a.length; j++){
            
            sum += Math.abs(a[j]-a[i]);
            
        }
        
        if(sum < min){
            min = sum;
            result = a[i];   
        }  
    }
    return result;
}
