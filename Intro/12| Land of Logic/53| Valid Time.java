boolean solution(String time) {
    
    String[] split = time.split(":");
    
    if(Integer.parseInt(split[0]) > 23 || Integer.parseInt(split[1]) > 59 ){
        return false;
    }
    return true;
}
