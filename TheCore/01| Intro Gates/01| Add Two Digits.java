int solution(int n) {
    
    //CONVERT TO STRING
    String s = String.valueOf(n);
    
    int sum  = Character.getNumericValue(s.charAt(0)) + Character.getNumericValue(s.charAt(1));
    
    return sum;
}
