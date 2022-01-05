char solution(String s) {
    int [] array = new int [s.length()]; //local    
    
        for(int i=0; i<s.length(); i++){
            array[i] = -1;
                for(int j=0; j<s.length();j++){
                    if(i!=j){   //check if i have same position j
                        if(s.charAt(i) == s.charAt(j)){
                       array[i] = j;
                       break;  //go to loop i 
                     }
                    }
                    
                }
        }
        
        int index = -1;
        for(int i=0; i<array.length; i++){
            if(array[i] == -1){
                index = i;
                break;
            }
        }
        
        if(index != -1) return s.charAt(index);
        else return '_';
    }
