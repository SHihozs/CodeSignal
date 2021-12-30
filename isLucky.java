boolean solution(int n) {
    
    String convert = String.valueOf(n);
    
    int first = 0;
    int end   = 0;
    
    for(int i=0, j=convert.length()-1; i<convert.length()/2; i++,j--){
         first += Character.getNumericValue(convert.charAt(i));
         end   += Character.getNumericValue(convert.charAt(j));
    }
    
    if(first == end){
        return true;
    }
       
    return false;
}