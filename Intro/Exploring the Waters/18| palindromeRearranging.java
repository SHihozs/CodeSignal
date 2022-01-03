boolean solution(String inputString) {

    HashMap<Character,Integer> hash = new HashMap<>();
    int count = 1;
    int value = 0;
    
    for(int i=0; i<inputString.length(); i++){
        
        if(!hash.containsKey(inputString.charAt(i))){
            
            hash.put(inputString.charAt(i),count); 
        }
        else{
            value = hash.get(inputString.charAt(i));
            value += 1;
            hash.put(inputString.charAt(i),value);
        }   
    }
    
    int odd = 0;
    for(Map.Entry<Character,Integer> m : hash.entrySet()){
        if(m.getValue() % 2 != 0){
            odd += 1;
        }
    }
    
    //NOT PALINDROME
    if(odd > 1){
        return false;
    }
    //PALINDREOME
    else{
        return true;
    }
}
