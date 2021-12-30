int[][] solution(int[][] image) {
    
    //MAKE A ANSWER ARRAY (ROW)
    int[][] array  = new int [image.length-2][];
    
    //MAKE A ANSWER ARRAY (COL)
    for(int i=0; i<array.length; i++){
        array[i] = new int [image[0].length-2];
    }
    
    //CHECK 3x3
    /*
        1. use i for iden index of answer array (row) 
        2. use j for iden index of answer array (col) 
    */
    
    for(int r=0; r+3 <= image.length; r++){
        for(int c=0; c+3 <= image[0].length;c++){
            
            int row = r;
            int col = c;
            int sum = 0;
            
            while(col < c+3 && row < r+3){
                sum += image[row][col];
                //CHANGE COL
                col++;
                
                if(col >= c+3 && row < r+3){
                    //CHANGE ROW
                    row++;
                    col = c;
                }
            }
           
            sum = sum/9;
            array[r][c] = sum;
        }
    }
   
    return array;  
}
