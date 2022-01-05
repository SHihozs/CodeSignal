int solution(int n) {

    /*
        1234 -> 234, 134, 124, 123 --> MAX IS --> 234
    */

    //CONVERT INT TO STRING
    String s = Integer.toString(n);
    int max  = Integer.MIN_VALUE;
    String result = "";
    
    for(int i=0; i<s.length(); i++){
        for(int j=0; j<s.length(); j++){
            if(i!=j){
                result += s.charAt(j);
            }
        }
        
        if(Integer.parseInt(result) > max){
            max = Integer.parseInt(result);
        }
        result = "";
    }
    return max;
}
