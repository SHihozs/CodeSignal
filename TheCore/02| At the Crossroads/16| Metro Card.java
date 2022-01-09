int[] solution(int lastNumberOfDays) {
    
    if(lastNumberOfDays == 28 || lastNumberOfDays == 30){
        int[]  arr = {31};
        return arr;
    }
    else{
        int[]  arr = {28,30,31};
        return arr;
    }

}
