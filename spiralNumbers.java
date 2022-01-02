int[][] solution(int n) {
    
    //https://javaconceptoftheday.com/how-to-create-spiral-of-numbers-matrix-in-java/
    
    int[][] result = new int [n][n];
    
    //INITIAL VALUE
    int value  = 1;
    int minCol = 0;
    int minRow = 0;
    int maxCol = n-1;
    int maxRow = n-1;
    
    //COUNT NUMBER
    while (value <= n*n){
        for (int i = minCol; i <= maxCol; i++){
            result[minRow][i] = value;  //[0][0] > [0][1] > [0][2]
            value++;
        }
 
        for (int i = minRow+1; i <= maxRow; i++) { 
            result[i][maxCol] = value;  //[1][2] > [2][2] 
            value++; 
        } 
             
        for (int i = maxCol-1; i >= minCol; i--){
            result[maxRow][i] = value;  //[2][1] > [2][0] 
            value++;
        }
             
        for (int i = maxRow-1; i >= minRow+1; i--){
            result[i][minCol] = value;  //[1][0] 
            value++;
        }
             
        minCol++;
        minRow++;
        maxCol--;
        maxRow--;
    }
    return result;   
}
