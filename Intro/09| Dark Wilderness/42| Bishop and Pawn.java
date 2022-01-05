boolean solution(String bishop, String pawn) {
    
     //CONVERT STRING TO INT(ASCII)
     int bishop_row  = (int)bishop.charAt(0) - 64 ; //A = 1
     int bishop_col  = bishop.charAt(1);
     
     int pawn_row  = (int)pawn.charAt(0) - 64 ; //A = 1
     int pawn_col  = pawn.charAt(1);
     
     //CALCULATE
     if(Math.abs(bishop_row - pawn_row) == Math.abs(bishop_col - pawn_col)){
         return true;
     }
     return false;
}
