boolean solution(int experience, int threshold, int reward) {

    if(experience + reward >= threshold){
        return true;
    }
    return false;
}
