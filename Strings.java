//Anagrams in the string
//parshally correct
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] num = new int[strs.length];
        for(int i = 0;i < strs.length;i++){
            int sum = 0;
            for(int j = 0;j < strs[i].length(); j++){
                sum += (int)strs[i].charAt(j);
            }
            num[i] = sum;
        }
        List<List<String>> lists = new ArrayList<>();
        HashMap<Integer,List<String>> container = new HashMap<>();
        for(int i = 0 ; i < num.length ; i++){
                container.put(num[i],new ArrayList<String>());
        }
        for(int i = 0 ; i < num.length ; i++){
            container.get(num[i]).add(strs[i]);
        }
        for (HashMap.Entry<Integer, List<String>> entry : container.entrySet()) {
            List<String> value = entry.getValue();
            lists.add(value);
        }
        return lists;
    }
}

Optimized

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        String[] str = new String[strs.length];
        for(int i  = 0 ; i < strs.length; i++){
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            str[i] = new String(temp);
        }
        HashMap<String,List<String>> container = new HashMap<>();
        List<List<String >> ans = new ArrayList<>();
        for(int i = 0 ; i < str.length ; i++){
            container.put(str[i],new ArrayList<String>());
        }
        for(int i  = 0 ; i < str.length; i++){
            container.get(str[i]).add(strs[i]);
        }
        for(HashMap.Entry<String,List<String>> entry: container.entrySet()){
            List<String> value = entry.getValue();
            ans.add(value);
        }
        return ans;
    }
}

//More optimized solution 

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> container = new HashMap<>();
        for(String s : strs){
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            if(! container.containsKey(new String(temp))){
                container.put(new String(temp) ,new ArrayList<String>());
            }
            container.get(new String(temp)).add(s);
        }
        return new ArrayList<>(container.values());
    }
}
//longest repeating character replacement
// Time Complexity :  O(n)
// Space Complexity : O(1)
//correct
class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int largestCount = 0, left = 0, maxlen = 0;
        for(int right = 0; right < s.length(); right ++){
            arr[s.charAt(right) - 'A']++;
            
            largestCount = Math.max(largestCount, arr[s.charAt(right) - 'A']);
            
            if(right - left + 1 - largestCount > k){     // The main equation is: right - left + 1 - largestCount...
                arr[s.charAt(left) - 'A']--;
                beg ++;
            }
            
            maxlen = Math.max(maxlen, right - left + 1);     
        }
        return maxlen;
    }
}

//parshially correct
class Solution {
    public int check(String s,char a){
        int t = 0 ,max = 0;
        for(int i = 0; i < s.length() ; i++){
            if(s.charAt(i) == a){
                t++;
            } else{
                t = 0;
            }
            max = max > t ? max : t;
        }
        return max;
    }
    public int checkEveryChar(String s , int k,char a){
        int t = k,r = 0,l = 0, maxlength = 0;
        for(int i = 0 ; i < s.length() ;i++){
            if(a != s.charAt(i) && t != 0){
                t--;
            } 
            maxlength = maxlength > (r-l)+1 ? maxlength : (r-l)+1;
            if(t==0 && i != s.length() - 1 && s.charAt(i + 1) != 'A'){
                t = k;
                l = i + 1;
            }
            r++;
        }
        return maxlength;
    }
    public int characterReplacement(String s, int k) {
        Set<Character> uniqueChars = new HashSet<>();
        int max = 0 ;
        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }
        for(Character character : uniqueChars){
            if(k == 0){
            return check(s,character);
        }
        int t = checkEveryChar(s,k,character);
        max = max > t ? max : t;
        }
        return max;
    }
}


// level : hard 
// pattern matching sustring
class Solution{
    static boolean match(String wild, String pattern)
    {
        // code here
        // if we go to the end of the string we are done out job
        if(wild.length() == 0 && pattern.length() == 0){
            return true;
        }
        //  remove all consecutive '*'
        if(wild.length() > 1 && wild.charAt(0) == '*'){
            int i = 0;
            while(i + 1 < wild.length() && wild.charAt(i + 1) == '*')
                i++;
            wild = wild.substring(i);
        }
        // there is no '*' present in the string
        if(wild.length() > 1 && wild.charAt(0) == '*' && pattern.length() == 0){
            return false;
        }
        // if the string contain the ?
        if((wild.length() > 1 && wild.charAt(0) == '?') || (wild.length() != 0 && pattern.length() != 0 && wild.charAt(0) == pattern.charAt(0))){
            return match(wild.substring(1),pattern.substring(1));
        }
        
        // if there is star then two posibilities
        if(wild.length() > 0 && wild.charAt(0) == '*'){
            return match(wild.substring(1),pattern) || match(wild,pattern.substring(1));
        }
        return false;
    }
}


// zigzag pattern for the string
class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1){
          return s;
        }
         StringBuilder ans = new StringBuilder();
         int n = s.length();
         int main_diff = 2 * (numRows - 1);
         int diagonalDiff,secondIndex;
         for(int i = 0; i < numRows ; i++){
           int index = i;
           while(index < n){
             ans.append(s.charAt(index));

            //  for the adjusent element
             if(i != 0 && i != numRows - 1){
               diagonalDiff =main_diff - 2 * i;
               secondIndex = diagonalDiff + index;
               if(secondIndex < n){
                 ans.append(s.charAt(secondIndex));
               }
             }
             index +=main_diff;
           }
         }
         return ans.toString();
    }
}

// reverse Integere with the limitations
class Solution {
    public int reverse(int x) {
        long reverseNum = 0;
        
        while (x != 0) {
            int reminder = x % 10;
            x /= 10;
            
            reverseNum = reverseNum * 10 + reminder;
        }
        if(reverseNum > Integer.MAX_VALUE || reverseNum<Integer.MIN_VALUE){
            return 0;
        }
        if(x<0){
            return (int)( 0 - reverseNum);
        }
        return (int)reverseNum;
    }
}

// string to integer
class Solution {
    public int myAtoi(String str) {
        
        final int len = str.length();

        if(len == 0){
          return 0;
        }

        int index = 0;

        while(index < len && str.charAt(index) == ' '){
          index++;
        }

        char ch;
      boolean isNegative = (ch = str.charAt(index)) == '-';

      if(isNegative || str.charAt(index) == '+'){
        index++;
      }

      int maxLimit = Integer.MAX_VALUE / 10;
      int result = 0;
      while(index < len && isDigit(ch = str.charAt(index))){
        int digit = ch -'0';
        if(result > maxLimit || (result == maxLimit && digit > 7)){
          return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        result = (result * 10) + digit;
        index++;
      }
      return isNegative ? -result : result;
    }

    private boolean isDigit(char ch){
      return ch >= '0' && ch <= '9';
    }
    
}
