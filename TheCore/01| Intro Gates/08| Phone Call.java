int solution(int min1, int min2_10, int min11, int s) {

    int sum    = 0;
    int result = 0;
    
    //MIN 1
    if(s >= min1){
        sum    =  s-min1;
        result =  1;
    }
     
    //MIN 2_10  
    int i = 2;
    while (sum >= min2_10 && i<11){
        sum     -= min2_10;
        result  += 1;
        i++;
    }  
    
    //MIN 11
    while(sum >= min11 && i>10){
       sum    -= min11;
       result += 1; 
    }
    
    return result; 
}
