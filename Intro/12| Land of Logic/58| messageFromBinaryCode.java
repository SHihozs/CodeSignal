String solution(String code) {
    
    List<String> list = new ArrayList<String>();
    int index = 0;
    while (index < code.length()) {
        list.add(code.substring(index, Math.min(index + 8,code.length())));
        index += 8;
    }
    
    int charCode = 0;
    String result   = "";
    for(String l : list){
        charCode = Integer.parseInt(l, 2); //binary to decimal
        result  += (char)charCode+"";      //decimal to ASCII
    }
    return result;
}
