int solution(int[] statues) {
    Arrays.sort(statues); 
    int result = 0;
    
    for(int i=0; i<statues.length-1; i++){
        if(statues[i+1] - statues[i] > 1){
            result += (statues[i+1] - statues[i])-1;
        }
    }
    return result;
}
