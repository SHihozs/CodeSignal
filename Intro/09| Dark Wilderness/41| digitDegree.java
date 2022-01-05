int solution(int n) {
    
    //7+7+7+7+7+3 = 38(1) 3+8 11(2) 1+1(3)
    int count = 0;
    
    //CONVERT INT TO STRING
    String num = Integer.toString(n);
    
    while(num.length()>1){
        
        int sum   = 0;
        
        for(int i=0; i<num.length(); i++ ){
            sum   += Character.getNumericValue(num.charAt(i));
        }
        num    = Integer.toString(sum);
        count += 1;
        
    }
    return count;
}
