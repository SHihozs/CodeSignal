int solution(int[] inputArray) {
    
    //FIND MAX OF ARRAY
    int max = Integer.MIN_VALUE;
    
    for(int i=0; i<inputArray.length; i++){
        if(inputArray[i] > max){
            max = inputArray[i];
        }
    }
    
    int jmp = 1;
    
    for(int i = 0; i <= max ; i+=jmp){
        
        for(int j = 0; j<inputArray.length; j++){
            
             //INPUTARRAY[j] == i MEANS JUMP = .... IS NOT OK
             if(inputArray[j] == i){
                 
                 //JUMP FAR
                 jmp += 1;
                 //SET INITIAL 
                 i=0;
             
             }
             
             //INPUTARRAY[j] != i MEANS JUMP = .... IS OK
        }
    }
        
    return jmp;
}
