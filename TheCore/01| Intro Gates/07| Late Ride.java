int solution(int n) {
     
     String hour = (n/60)+"";
     String min  = (n%60)+"";
     int sum = 0;
     
     for(int i=0; i<hour.length() ;i++){
         sum += Character.getNumericValue(hour.charAt(i)); 
     }
     
     for(int i=0; i<min.length() ;i++){
         sum += Character.getNumericValue(min.charAt(i)); 
     }
     
    return sum;
    
    //return hours/10 + hours%10 + minutes/10 + minutes%10;
    
}
