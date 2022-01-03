String[] solution(String[] inputArray) {
    
     int max =Integer.MIN_VALUE;
     int count = 0;
     
     for(int i=0; i<inputArray.length; i++){
        
        if(inputArray[i].length() > max){
            max = inputArray[i].length();
            count = 1;
        }
        
        else if(inputArray[i].length() == max){
            count++;
        } 
     } 
    
     String [] result = new String[count];   
     int j = 0;
     
     for(int i=0; i<inputArray.length; i++){

         if(inputArray[i].length() == max){
             result[j] = inputArray[i];
             j++;
         }
     } 
    
    return result;      
}
