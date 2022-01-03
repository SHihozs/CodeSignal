int[] solution(int[] a) {
    
int [] team= new int[2];

    for(int i=0; i<a.length; i++){
        if(i % 2 == 0){
            team[0] += a[i];
        }
        else{
            team[1] += a[i];
        }
    }
    return team;
}
