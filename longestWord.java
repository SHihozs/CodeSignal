String solution(String text) {
    
    String longest = "";
    String result  =  "";
    int count = 0;
    int max = Integer.MIN_VALUE;
    
    for(int i=0; i<text.length(); i++){
        if((text.charAt(i) >= 'a' && text.charAt(i) <= 'z') || (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z')){
            count   += 1;
            longest += text.charAt(i);
        }
        else{
            //CHECK LONGEST
            if(count > max){
                max    = count;
                result = longest;
            }
        count   = 0;
        longest = "";
        }
    } 
    
        //text: "ABCd"
        //text: "aaa bb cccc"
        
        if(result.length() < longest.length()){
           result = longest;
        }
    return result;
}
