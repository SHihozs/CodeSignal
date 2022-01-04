boolean solution(String cell1, String cell2) {
    
    //CONVERT CHAR TO INT(ASCII)
    int c1_vertical  = (int)cell1.charAt(0) - 64 ; //A = 1
    int c1_horizon   = cell1.charAt(1);
    int c1_color     = -1;
    
    int c2_vertical  = (int)cell2.charAt(0) - 64 ;
    int c2_horizon   = cell2.charAt(1);
    int c2_color     = -1;
    
    if(c1_vertical % 2 == c1_horizon % 2){
        
        c1_color = 1; //LIGHT
        
    }
    else{
        c1_color = 0; //DARK
    }
    
    if(c2_vertical % 2 == c2_horizon % 2){
        
        c2_color = 1; //LIGHT
        
    }
    else{
        c2_color = 0; //DARK
    }
    
    //COMPARE
    
    if(c1_color == c2_color){
        return true;
    }
    else{
        return false;
    }  
}
