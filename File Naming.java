String[] solution(String[] names) {

    HashSet<String> hashSet = new HashSet<>();
    String[] result = new String[names.length];
    
    for(int i=0; i<names.length; i++){
        String name = names[i];
        if(!hashSet.contains(name)){
            hashSet.add((name));
            result[i] = name;
        }
        else{
            String nameDuplicate = name;
            int k=0;
            while(hashSet.contains(nameDuplicate)){
                k += 1;
                nameDuplicate = name + "(" + k + ")";
            }
            
            hashSet.add(nameDuplicate);
            result[i] = nameDuplicate;
        }
    }
    return result;
 }
 