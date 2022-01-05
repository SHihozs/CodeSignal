boolean solution(int[] a) {
    Map<Integer,Boolean> map = new HashMap<Integer,Boolean>();
    
    for(int i=0; i<a.length; i++){
        if(!map.containsKey(a[i])){
            map.put(a[i], false);
        }
        else{
            map.put(a[i], true);
        }    
    }
    
    for(Map.Entry<Integer,Boolean> m : map.entrySet()){
        if(m.getValue() == true){
            return true;
        }
    }
    return false;
}
