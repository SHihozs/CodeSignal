char solution(String inputString) {
    
    char result = 0;
    
    for(int i=0; i<inputString.length(); i++){
        
        if(Character.isDigit(inputString.charAt(i))){
            result = inputString.charAt(i);
            break;
        }
    }
    return result ;
}
