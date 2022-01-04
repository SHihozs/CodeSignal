boolean solution(String[] inputArray) {
   
    boolean[] keeps = new boolean[inputArray.length];
    findSequence(inputArray, null, keeps, 0);
    return pass;
}
boolean pass = false; 

boolean diffOne(String s1, String s2) {
    int diff = 0;
    for (int j = 0 ; j < s1.length() ; j++) {
        if (s1.charAt(j) != s2.charAt(j)) {
            diff++;
            if (diff > 1) {
                return false;
            }
        }
    }
    return diff == 1;
}

void findSequence (String[] a, String prev, boolean[] keeps, int n) {
    if (n == a.length) {
        pass = true;
        return;
    }
    for (int i = 0; i < a.length; i++) {
        if (!keeps[i] && (prev == null || diffOne(prev, a[i]))) {
            keeps[i] = true;
            findSequence(a, a[i], keeps, n+1);
            keeps[i] = false;
        }
    }
}
