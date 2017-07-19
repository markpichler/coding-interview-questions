/*
Given an array strings, determine whether it follows the sequence given 
in the patterns array. In other words, there should be no i and j for 
which strings[i] = strings[j] and patterns[i] ≠ patterns[j] or for which 
strings[i] ≠ strings[j] and patterns[i] = patterns[j].
-CodeFights.com
*/

boolean areFollowingPatterns(String[] strings, String[] patterns) {
    
    Map<String, String> patternMap = new HashMap<String, String>();
    Set<String> patternSet = new HashSet<String>();
    
    String keyString, valString;
    
    //Iterate across the given strings (assumed to be the same lengths).
    for (int i = 0; i < strings.length; i++) {
        
        keyString = strings[i];
        valString = patterns[i];
        
        if (patternMap.containsKey(keyString)) {
            //Determine if the patterns[] string mapped to the string 
            //in strings[] is the same as the already mapped pair. 
            if (!valString.equals(patternMap.get(keyString))) 
                return false;
        }
        else {
            //Determine if string in patterns[] has been mapped already
            //to a different string in strings[].
            if (!patternSet.add(valString)) 
                return false;
            //Add new mapping
            patternMap.put(keyString, valString);
        }   
    }
    
    return true;

}
