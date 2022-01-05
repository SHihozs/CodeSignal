int solution(int divisor, int bound) {
    
    int i = 1;
    int result = 0;
    
    while(divisor*i <= bound){
        result = divisor * i;
        i++;
    }
    return result;
}
