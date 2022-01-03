boolean solution(String inputString) {
    
    boolean check_palindrome = true;
    
    if(inputString.length() == 1){
        check_palindrome = true;
    }
    else{
        for(int i=0; i<inputString.length(); i++){
            if(inputString.charAt(i) != inputString.charAt(inputString.length() - (i+1))){
                check_palindrome = false;
            }
        }
    }
  
    return check_palindrome;
}
