boolean solution(int score1, int score2) {

    if(score1 > 7 || score2 > 7){return false;}
    
    if(score1 == score2){return false;}
    
    if(score1 == 5){
        if(score2 != 7){return false;}
    }
    if(score1 == 7){
        if(score2 < 5){return false;}
    }
    if(score2 == 5){
        if(score1 != 7){return false;}
    }
    if(score2 == 7){
        if(score1 < 5){return false;}
    }
    
    if(score1 != 6 && score1 != 7 && score2 < 6){return false;}
    
    if(score2 != 6 && score2 != 7 && score1 < 6){return false;}

    return true;
    
    
    /*
    boolean solution(int score1, int score2) 
    {
        int win = Math.max(score1,score2);
        int lose = Math.min(score1,score2);

        return (win == 6 && lose < 5) || (win == 7 && lose <= 6 && lose >= 5);
    }
    */
    
}
