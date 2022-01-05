int solution(String s) {
    
    Queue<Character> queue = new LinkedList<>();
    
    for(int i=0; i<s.length(); i++){
        if(!queue.contains(s.charAt(i))){
            queue.add(s.charAt(i));
        }
    }
    
    int count=0;
    while(!queue.isEmpty()){
        queue.poll();
        count += 1;
    }
    
    return count;

}
