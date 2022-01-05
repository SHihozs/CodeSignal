String solution(String inputString) {
    
    String result = "";
    for(int i=0; i<inputString.length();i++){
        if(Character.isDigit(inputString.charAt(i))){
            result += inputString.charAt(i);
        }  
        else{
            return result;
        }
    }
    return result;
}
