boolean solution(String inputString) {

    String[] s_split = inputString.split("-");
    
    if(inputString.charAt(0) == '-' || inputString.charAt(inputString.length()-1) == '-'){return false;}
    
    for(int i=0; i<s_split.length; i++){
        if(s_split[i].length() != 2){return false;}
       
       
        if((s_split[i].charAt(0) < '0' || s_split[i].charAt(0) > '9')&&
           (s_split[i].charAt(0) < 'A' || s_split[i].charAt(0) > 'F')){return false;}
        if((s_split[i].charAt(1) < '0' || s_split[i].charAt(1) > '9')&& 
           (s_split[i].charAt(1) < 'A' || s_split[i].charAt(1) > 'F')){return false;}    
            
    }
    return true; 
}
