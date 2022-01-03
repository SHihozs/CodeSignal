int solution(String s1, String s2) {

int sum = 0;

    for(int i=0; i<s1.length(); i++){
     
        for(int j=0; j<s2.length(); j++){
         
             if(s1.charAt(i) == s2.charAt(j)){
                 sum += 1;
                 s2 = s2.replaceFirst(String.valueOf(s2.charAt(j)),"*");
                 break;
             }  
        }   
    }
    return sum;
}
