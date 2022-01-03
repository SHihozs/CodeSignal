int solution(int[][] matrix) {
int sum = 0;

      //i = column & j = row
      for(int i=0; i<matrix[0].length; i++){     
          for(int j=0; j<matrix.length;j++){
              //CHOOSE VERTICAL ROW
              if(matrix[j][i] == 0){
                  break;
              }
              else{
                  sum += matrix[j][i];
              }
          }
      }
      
      return sum;  
}
