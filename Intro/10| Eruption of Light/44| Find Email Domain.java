String solution(String address) {
    
    //Given a valid email address, find its domain part
    String[] string_split  = address.split("@");
    
    return string_split[string_split.length-1];
}
