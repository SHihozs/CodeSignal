String solution(String inputString) {
    
    Stack<Character> stack = new Stack<>();
    StringBuilder rev = new StringBuilder();
    
        for(int i=0; i<inputString.length();i++){
            if(inputString.charAt(i) != ')'){
                stack.push(inputString.charAt(i));
            }
            else{
                while(stack.peek() != '('){
                   rev.append(stack.pop());
                }
                stack.pop(); //POP '('
        
                //REV TO STACK
                for(int j=0; j<rev.length(); j++){
                    stack.push(rev.charAt(j));
                }     
                rev.setLength(0); //CLEAR REV
            }
        }
        
    StringBuilder result = new StringBuilder();
        
        //STACK [FILO] TO STRING 
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        //REVERSE WHEN POP FROM STACK
        result.reverse(); 
        
        return result.toString();
    }
    
