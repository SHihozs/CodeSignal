int solution(int[][] matrix) {
    
    HashSet<String> hashSet = new HashSet<>();
    String temp = "";
    
     for(int i=0; i<matrix.length-1; i++){
         for(int j=0; j<matrix[0].length-1; j++){
             
             temp = matrix[i][j] + "-" + matrix[i][j+1] + "-" + matrix[i+1][j] + "-" + matrix[i+1][j+1];                 hashSet.add(temp);
         }
     }
     return hashSet.size();
}
