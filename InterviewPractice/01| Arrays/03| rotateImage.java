int[][] solution(int[][] a) {

    int[][] b = new int [a.length][a[0].length];
    
    /*
    a = [[1, 2, 3],
         [4, 5, 6],
         [7, 8, 9]]
        
        i = 0
        k = a[i].length-1 so k=2 --> [7,8,9]
    */
    
        for(int i=0; i<a.length; i++){  
            int k = a[i].length-1; 
                for(int j=0; j<a[i].length; k--,j++){    
                    b[i][j] = a[k][i];
            }
        } return b; 
    }
