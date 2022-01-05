int solution(int upSpeed, int downSpeed, int desiredHeight) {
    
    int firstReach = 0;
    int result = 0;
    
    while(firstReach < desiredHeight){
    
        //DAY
        firstReach += upSpeed;
        result += 1;
        
        if(firstReach >= desiredHeight){
            break;
        }
        //NIGHT
        else{
            firstReach -= downSpeed;
        }
    }
    
    return result;
    
}
