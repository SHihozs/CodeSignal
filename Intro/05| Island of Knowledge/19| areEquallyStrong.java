boolean solution(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {
    
    //MY
    int my_max = 0;
    int my_min = 0;
    
    if(yourRight > yourLeft){
        my_max = yourRight;
        my_min = yourLeft;
    }
    else{
        my_max = yourLeft;
        my_min = yourRight;
    }
    
    //FRIEND
    int friend_max = 0;
    int friend_min = 0;
    
    if(friendsRight > friendsLeft){
        friend_max = friendsRight;
        friend_min = friendsLeft;
    }
    else{
        friend_max = friendsLeft;
        friend_min = friendsRight;
    }
    
    
    if(my_max != friend_max || my_min != friend_min){
        return false;
    }
    else{
        return true;
    }
    
}
