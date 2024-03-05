class Solution {
    public int[] plusOne(int[] digits) {
        for( int i = digits.length -1; i >= 0; i--){
            if(digits[i] + 1 == 10){
                if(digits[i] == 9 && i == 0){
                    int[] temp = new int[digits.length + 1];
                    temp[0] = 1;
                    digits[i] = 0;
                    System.arraycopy(digits,0,temp,1,digits.length);
                    return temp;
                }
                digits[i] = 0;
            } else{
                digits[i] += 1;
                break;
            }
        }
        return digits;
    }

// optomized answer
class Solution {
    public int[] plusOne(int[] digits) {
        for( int i = digits.length -1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[digits.length + 1]; // array add one place at the starting when we change the length of that array 
        digits[0] = 1;
        return digits;
    }
}
