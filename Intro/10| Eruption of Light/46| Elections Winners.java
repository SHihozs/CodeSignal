int solution(int[] votes, int k) {
    
    //FIND MAX VOTES IN ARRAY
    int max = Integer.MIN_VALUE;
    for(int i=0; i<votes.length; i++){
        if(votes[i] > max){
            max = votes[i];
        }
    }
    
    //FIND BEST CASE
    int count = 0;
    int value = 0;
    
    for(int i=0 ; i<votes.length ; i++){
        if((votes[i]+k) > max){
            count += 1;
        }
        else{
            if(votes[i] == max){
                value += 1;
            }
        }
    }
    
    if(value > 1){
        return 0;
    }
    else if (value == 1){
        count = value;
    }
    
    return count;
}
