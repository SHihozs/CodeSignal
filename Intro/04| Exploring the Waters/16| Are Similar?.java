boolean solution(int[] a, int[] b) {
    
    /*
        [1,2,3]
        [2,1,3]
        
        i=0 sum = 1
        i=1 sum = 2
        i=2 sum = 2
    */
    
    int sum = 0;
    for (int i = 0; i < a.length; i++) {
        
        //IF INDEX a[i] != INDEX b[i]
        if(a[i] != b[i]){
           
            sum++;
        }
    } 
    
    Arrays.sort(a);
    Arrays.sort(b);
    
    if(Arrays.equals(a, b) && sum < 3){
        return true;
    }
    
    return false;
}
    
