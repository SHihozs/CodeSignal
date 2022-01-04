int solution(int deposit, int rate, int threshold) {
    
    int   year  = 0;
    float money = (float)deposit;
    float f_rate = (float)rate/100;
    
    while(money<threshold){
        money   = money+(money*f_rate);
        year += 1;
    }
    
    return year;

}
