boolean solution(String inputString) {
    
    //REGEX
    String buf[] = inputString.split("\\.");
    int convert  = 0;
    
    for(int i=0; i<buf.length; i++){
        
        try{
            //PARSEINT USE WHEN CONVERT STRING TO INT
            convert = Integer.parseInt(buf[i]);
        }
        catch(NumberFormatException e){
            return false;
        }
        
        //CHARCK CONDITION
        //1. SIZE
        if(buf.length > 4 || buf.length < 4){
            return false;
        }
        
        //2. ADDRESS
        if(convert > 255 || convert < 0){
            return false;
        }
        
        //3. FIRST ZERO
        if(buf[i].length() > 1 && buf[i].charAt(0) == '0'){
            return false;
        }       
    }
    return true;
}
