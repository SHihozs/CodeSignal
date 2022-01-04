String solution(String inputString) {
        
    String result = "";

    for(int i=0; i<inputString.length();i++){
     
        if(inputString.charAt(i) == 'z' || inputString.charAt(i) == 'Z' ){
            
            //CONVERT Z TO A
           result +=   'a';
           
        }
        else{
            
           //CHAR(TEXT) TO INT
           int int_temp = (int)inputString.charAt(i)+1 ;
           
           //INT TO CHAR(TEXT)
           char char_temp = (char)int_temp;
           
           result  += char_temp;
        }
}
return result;
}
