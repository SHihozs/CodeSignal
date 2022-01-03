String[] solution(String[] picture) {
    
    Deque<String> deque  = new ArrayDeque<>();
    
    for(String s : picture){
        deque.add('*' + s + '*');
    }
    
    //LENGHT (*abc* = 5)
    int count =  deque.peekFirst().length();
    String asterisk = "";
    
    for(int i=0; i<count; i++){
       asterisk += "*";
    }
    
    deque.addFirst(asterisk);
    deque.addLast(asterisk);
    
    String[] result = new String[deque.size()];
    int i=0;
    
    while(!deque.isEmpty()){
        result[i] = deque.poll();
        i++;
    }
    
    return result;
}
