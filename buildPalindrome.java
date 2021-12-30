String solution(String st) {

    /*
        abaa     --(rev)->   aaba
        i=0;     abaa   aaba
        i=1;     a|baa  aab|a
        i=2;     ab|aa  aa|ba
    */
    
    StringBuilder sBuilder = new StringBuilder();
    String sb = sBuilder.append(st).reverse().toString();
    String result = "";
    
    for(int i=0; i<st.length(); i++){
        if(sb.startsWith(st.substring(i))){
             //ab (i=0 - i=1) + aaba (rev)
             result = st.substring(0,i) + sb;
             break;
        } 
    } 
    return result;  
}
