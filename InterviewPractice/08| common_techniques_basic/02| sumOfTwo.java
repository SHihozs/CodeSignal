boolean solution(int[] a, int[] b, int v) {
    
  HashSet hash = new HashSet<>();
  
  //PUT A IN HASHMAP
  for(int i=0; i<a.length; i++){
      hash.add(a[i]);
  }
  
  //CHECK a = v-b
  for(int i=0; i<b.length; i++){
      //PAIR EXIST
      if(hash.contains(v-b[i])) return true;
  }
  
  //NO PAIR 
  return false;
}
