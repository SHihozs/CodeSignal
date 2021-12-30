int[] solution(int[] inputArray, int k) {

    /*
        array    : [2, 4, 6, 8, 10]
        position :  1  2  3  4   5
        k: 2
        result   :  [2, 6, 10]
    
    */
    
    Queue<Integer> queue = new LinkedList<>();
    
    for(int i=0; i<inputArray.length; i++){
        if((i+1) % k != 0){
            queue.add(inputArray[i]);
        }
    }
    
    int[] result = new int[queue.size()];
    
    for(int i=0; i<result.length; i++){
        result[i] = queue.poll();
    }
    
    return result;
    
}
