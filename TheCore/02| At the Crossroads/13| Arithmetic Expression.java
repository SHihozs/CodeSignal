boolean solution(int a, int b, int c) {
    
    if((a+b==c) || (a-b==c) || (a*b==c) || ((float)a/b)==c){
        return true;
    }
    else{
        return false;
    }
}
