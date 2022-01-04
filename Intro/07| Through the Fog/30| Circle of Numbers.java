int solution(int n, int firstNumber) {
    
    //if n=? then the result far from first number n/2
    
    if(firstNumber > n/2){
        return firstNumber - (n/2);
    }
    else if(firstNumber == n/2){
        return 0;
    }
    else{
        return firstNumber + (n/2);
    }   
}
