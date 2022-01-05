int solution(int product) {
    
    Stack<Integer> stack = new Stack<>();
    
    if(product == 0){return 10;}
    if(product < 10){return product;} //one digit
    
    for(int i=9; i>1; i--){
        if(product % i == 0){
           product /= i;
           stack.push(i);
           i=10; //protect i--
        }
        if(product < 10){
           stack.push(product);
           break;
        }
    }
    
    //case 33 = 1*11 --> (11==prime)
    if(product > 10){
        return -1;
    }
    
    String result = "";
    while(!stack.isEmpty()){
        result += stack.pop();
    }
    
    //PRIME
    if(result == ""){
        return -1;
    }
    
    return Integer.parseInt(result);
}


