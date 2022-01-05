boolean solution(int[][] grid) {
    
    Queue<Integer> queueRow = new LinkedList<>();
    Queue<Integer> queueCol = new LinkedList<>();
    
    //LOOP ROW & COL
    for(int i=0; i<grid[0].length; i++){//row
        for(int j=0; j<grid[0].length; j++){//col
        
           int valueRow = grid[i][j];
           int valueCol = grid[j][i];
            
            //ROW
            if(!queueRow.contains(valueRow)){
                queueRow.add(valueRow);
            }
            else{
                queueRow.clear();
                return false;
            }
            
            //COL
            if(!queueCol.contains(valueCol)){
                queueCol.add(valueCol);
            }
            else{
                queueCol.clear();
                return false;
            }  
        }
        queueRow.clear();
        queueCol.clear();
    }
    
    //SUB-MATRIX
    Queue<Integer> queue = new LinkedList<>();
    int col = 0;
    int row = 0;

    //LOOP SUB-MATRIX
    for(int i=0; i<9; i++){
      for(int r=row; r<row+3; r++){
        for(int c=col; c<col+3; c++){   
            
            int value = grid[r][c];
            
            if(!queue.contains(value)){
                queue.add(value);
            }
            else{
                queue.clear();
                return false;
            } 
        }  
    }
    queue.clear();
    
    //LOOP SUB-MATRIX [BIG] 
    if(col ==  6){
       row += 3;
       col  = 0;
    }
    else{
       col += 3; 
    }
    
  }
  return true;
}
