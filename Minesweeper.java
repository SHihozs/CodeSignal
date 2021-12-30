int[][] solution(boolean[][] matrix) {
    
    int [][] answer = new int [matrix.length][matrix[0].length];
    
    for(int i=0; i<matrix.length; i++){
        for(int j=0; j<matrix[0].length; j++){
            
            int sum = 0;
            
            //CORNOR
            if(i == 0 && j == 0){//ABOVE-LEFT
                if(matrix[i][j+1] == true){
                    sum += 1;
                }
                if(matrix[i+1][j] == true){
                    sum += 1;
                }
                if(matrix[i+1][j+1] == true){
                    sum += 1;
                }  
            }
                 
            else if(i == 0 && j == matrix[i].length-1){//ABOVE-RIGHT
                if(matrix[i][j-1] == true){
                    sum += 1;
                }
                if(matrix[i+1][j] == true){
                    sum += 1;
                }
                if(matrix[i+1][j-1] == true){
                    sum += 1;
                }
                
            }
            
            else if(i == matrix.length-1 && j == 0){//UNDER-LEFT
                if(matrix[i][j+1] == true){
                    sum += 1;
                }
                if(matrix[i-1][j] == true){
                    sum += 1;
                }
                if(matrix[i-1][j+1] == true){
                    sum += 1;
                }
            }
            
            else if(i == matrix.length-1 && j == matrix[i].length-1){//UNDER-RIGHT
                if(matrix[i][j-1] == true){
                    sum += 1;
                }
                if(matrix[i-1][j-1] == true){
                    sum += 1;
                }
                if(matrix[i-1][j] == true){
                    sum += 1;
                }
            }
            
            //BORDER
            
            else if(j == 0){//LEFT
                
                if(matrix[i-1][j] == true){
                    sum += 1;
                }
                if(matrix[i-1][j+1] == true){
                    sum += 1;
                }
                if(matrix[i+1][j] == true){
                    sum += 1;
                }
                if(matrix[i+1][j+1] == true){
                    sum += 1;
                }
                if(matrix[i][j+1] == true){
                    sum += 1;
                }
            }
            
            else if(j == matrix[i].length-1){//RIGHT
                if(matrix[i-1][j] == true){
                    sum += 1;
                }
                if(matrix[i-1][j-1] == true){
                    sum += 1;
                }
                if(matrix[i+1][j] == true){
                    sum += 1;
                }
                if(matrix[i+1][j-1] == true){
                    sum += 1;
                }
                if(matrix[i][j-1] == true){
                    sum += 1;
                }    
            }
            
            else if(i == 0){//ABOVE
                if(matrix[i][j-1] == true){
                    sum += 1;
                }
                if(matrix[i][j+1] == true){
                    sum += 1;
                }
                if(matrix[i+1][j-1] == true){
                    sum += 1;
                }
                if(matrix[i+1][j] == true){
                    sum += 1;
                }
                if(matrix[i+1][j+1] == true){
                    sum += 1;
                }
            }
            
            else if(i == matrix.length-1){//UNDER
                if(matrix[i][j-1] == true){
                    sum += 1;
                }
                 if(matrix[i][j+1] == true){
                    sum += 1;
                }
                 if(matrix[i-1][j-1] == true){
                    sum += 1;
                }
                if(matrix[i-1][j] == true){
                    sum += 1;
                }
                if(matrix[i-1][j+1] == true){
                    sum += 1;
                }
            }
            
            //MIDDLE
            else{
                if(matrix[i-1][j-1] == true){ //ABOVE-LEFT
                    sum += 1;
                }
                if(matrix[i-1][j] == true){ //ABOVE-MID
                    sum += 1;
                }
                if(matrix[i-1][j+1] == true){ //ABOVE-RIGHT
                    sum += 1;
                }
                if(matrix[i][j-1] == true){ //MID-LEFT
                    sum += 1;
                }
                if(matrix[i][j+1] == true){ //MID-RIGHT
                    sum += 1;
                }
                if(matrix[i+1][j-1] == true){ //UNDER-LEFT
                    sum += 1;
                }
                if(matrix[i+1][j] == true){ //UNDER-MID
                    sum += 1;
                }
                if(matrix[i+1][j+1] == true){ //UNDER-RIGHT
                    sum += 1;
                }
                
            }
            
            answer[i][j] = sum;  
        } 
            
    }
    return answer;
}
