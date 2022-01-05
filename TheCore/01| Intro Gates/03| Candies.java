int solution(int n, int m) {

int divide = 0;
    while(m >= n){
        
        divide += n;
        m -= n;
    }
    return divide;
}
