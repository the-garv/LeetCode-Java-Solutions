class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        ArrayList<String> result = new ArrayList<String>();
        //split the array and then check the first secound word from aaray as i and i+1 
        String[] words = text.split(" ");
        for(int i=0;i<words.length-2;i++){
            if(words[i].equals(first) && words[i+1].equals(second)){
                result.add(words[i+2]);
            }
        }
        return Arrays.copyOf(result.toArray(), result.size(), String[].class);
    }
}
