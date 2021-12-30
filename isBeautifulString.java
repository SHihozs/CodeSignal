boolean solution(String inputString) {
    
    TreeMap<Character,Integer> treemap = new TreeMap<>(); //SORT KEY

    //ADD ALL ALPHABET
    for(int i=0; i<26; i++){
        treemap.put((char)(i+97), 0); //97 = a
    }
    
    //COUNT ALPHABET
    for(int i=0; i<inputString.length(); i++){
        treemap.put(inputString.charAt(i),treemap.get(inputString.charAt(i))+1);
    }
    
    int prev_value = Integer.MAX_VALUE;
    
    for(Map.Entry<Character,Integer> m : treemap.entrySet()){
        if(m.getValue() > prev_value){
            return false;
        }else{
            //THE HIGHEST ALPHABET MUST HAVE THE HIGHEST VALUE.
            prev_value = m.getValue();
        }
    }
    return true;
}
