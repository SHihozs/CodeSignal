int solution(int[] a) {

int [] array = new int [a.length]; //local

    for(int i=0; i<a.length; i++){
        array[i] = -1;
        
        for(int j=i+1; j<a.length; j++){
            
            if(a[i] == a[j]){ 
               array[i] = j;
               break; //go to loop next i
            }  
        } 
    }
    
    int min   = Integer.MAX_VALUE;
    int index = -1;
    
    for(int i=0; i<array.length; i++){
        if(array[i] < min && array[i] != -1){
            min   = array[i];
            index = i;
        }
    } 
    
    if(index == -1) return index;
    else return a[index];
}
