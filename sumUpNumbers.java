int solution(String inputString) {
    
    String add = "";
    int sum    = 0;
    
    for(int i=0; i<inputString.length(); i++){
        if(Character.isDigit(inputString.charAt(i))){
            add += inputString.charAt(i);
        }
        else{
            //ALPHABET
            if(add != ""){
               sum += Integer.parseInt(add);
               add  = "";
            }       
        }
    }
    
    //inputString: "123450"
    if(add != ""){
       sum += Integer.parseInt(add);
    }
    
    return sum;
}
