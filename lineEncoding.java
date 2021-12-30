String solution(String s) {
    
    Queue<Character> queue = new LinkedList<>();
    String result = "";
    int count = 0;
    
    for(int i=0; i<s.length(); i++){
        if(!queue.isEmpty() && s.charAt(i) != queue.peek()){
            if(count == 1){
                result += queue.poll();
                queue.clear();
                queue.add(s.charAt(i));
                count = 1;
            }
            else{
                result += Integer.toString(count) + queue.poll(); 
                queue.clear();
                queue.add(s.charAt(i));
                count = 1;
            }    
        }
        else{
            queue.add(s.charAt(i));
            count  += 1;
        }
    }
    
    if(!queue.isEmpty()){
        if(count != 1){
            //s: "ccccccccccccccc"
            result += Integer.toString(count) + queue.poll(); 
        }
        else{
            //s: "aabbbc" --> get output --> "2a3b1c" (last index with count = 1)
            result += queue.poll();
            queue.clear();
        }
        
    }
    return result;
}
