int[] solution(int[] a) {
    
    int temp = 0;
    
    for(int i=0; i<a.length; i++){
        for(int j=i+1; j<a.length; j++){
            if(a[i] == -1){
                a[i] = a[i];
                break;
            }
            else{
                if(a[i] > a[j] && a[j] != -1){
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;       
                }
                else{
                    a[i] = a[i];
                }
            }
        }
    }
    return a;
}
